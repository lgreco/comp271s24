/**
 * A simple parametric class to store key-value pairs in an array with nearly
 * O(1) insertion and retrieval performance based on the key value. The class
 * expects a linkable object node that takes two objects of generic types <K>
 * and <V> for key and value respectively. It uses this K-V node to create the
 * foundation array for this structure.
 */
public class HashTable271<K, V> {

    /* ----------------------------- Constants ----------------------------- */

    private static final int DEFAULT_SIZE = 4;
    private static final int DEFAULT_RESIZE_BY = 2;
    private static final double DEFAULT_THRESHOLD = 0.75;
    private static final String EMPTY = "STRUCTURE IS EMPTY";

    /* ------------------------------- Fields ------------------------------ */

    /** The foundation array of the structure */
    private KVNode<K, V>[] table;
    /** Factor to resize foundation array when it's time to rehash */
    private int resizeBy;
    /**
     * The ratio of nodes to length of foundation array. When it exceeds a specified
     * threshold, it's time to rehash
     */
    private double loadFactor;
    /** Determine swhen it's time to rehash */
    private double threshold;
    /** Number of nodes in the structure; needed to compute this.loadFactor */
    private int nodeCounter;
    /** Experimental: shows how many elements of this.table are used */
    private int tableUse;
    /** Experimental: tracks the number of nodes per array position */
    private int[] chainLength;
    /** Experimental: tracks the longest chain in this.table */
    private int longestChainLength;
    
    /* --------------------------- Constructors ---------------------------- */

    /**
     * Full constructor
     * 
     * @param size      int initial size of the foundation array
     * @param resizeBy  int factor to resize foundation array when it's time to
     *                  rehash
     * @param threshold double value to determine when it's time to rehash
     */
    @SuppressWarnings("unchecked")
    public HashTable271(int size, int resizeBy, double threshold) {
        this.table = new KVNode[size];
        this.resizeBy = resizeBy;
        this.threshold = threshold;
        this.loadFactor = 0;
        this.nodeCounter = 0;
        this.tableUse = 0;
        this.chainLength = new int[size];
        this.longestChainLength = 0;
    } // full constructor

    /** Default constructor */
    public HashTable271() {
        this(DEFAULT_SIZE, DEFAULT_RESIZE_BY, DEFAULT_THRESHOLD);
    } // default constructor

    /* ---------------------- Accessors and Mutators ----------------------- */

    /* ------------------------- Principal methods ------------------------- */

    /**
     * Accepts a pair of key-value objects, of generic types K and V respectively,
     * creates a KV node, obtains a hashcode from variable <K> key, and finds the
     * appropriate location for the node in this.table. Objects of type <K> are
     * expected to have a {@code int .hashCode()} function; otherwise we'll end up
     * inheriting Object.hashCode() which may not be the best choice for collision
     * avoidance.
     * 
     * @param key   K object with the key value of the data we wish to hash
     * @param value V object with the remaining data to hash. Note that in some
     *              cases object V may contain object K. For example, a Person may
     *              have a SSN which is used as an Integer boxed type for hashing.
     */
    @SuppressWarnings({ "unchecked" })
    public void put(K key, V value) {
        // Combine the key and value objects into a linkable node
        KVNode<K, V> newNode = new KVNode<K, V>(key, value);
        // Obtain the hash code for the key object.
        int hashedKey = key.hashCode();
        // Index this hashcode to an array position
        int index = findIndex(hashedKey, this.table.length);
        // If the array position has another node, chain it to the new node
        if (this.table[index] != null) {
            newNode.setNext(this.table[index]);
        } else {
            // Otherwise, increment the usage of this.table as we are about to place the
            // first node in position [index]
            this.tableUse++;
        }
        // Place the new node in position [index]
        this.table[index] = newNode;
        // Update node counter
        this.nodeCounter++;
        // Experimental: update the chain length for position [index]
        this.chainLength[index]++;
        // Euxperimental: pdate the max chain length
        if (this.chainLength[index] > this.longestChainLength) {
            this.longestChainLength = this.chainLength[index];
        }
        // Update load factor
        this.loadFactor = (double) this.nodeCounter / (double) this.table.length;
        // If load factor exceeds threshold, rehash the structure
        if (this.loadFactor > this.threshold) {
            this.rehash();
            System.out.println("\nAfter rehashing:");
            System.out.println(this.describe());
        }
    } // method put

    /**
     * Rehash the structure by creating a larger KVNode array and move the nodes
     * from this.table to the temporary array. When done replace this.table with
     * temporary array.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void rehash() {
        // Temporary and larger array
        KVNode[] temp = new KVNode[this.resizeBy * this.table.length];
        // Temporary array to replace chain length counts
        int tempLengths[] = new int[this.resizeBy * this.table.length];
        // Temporary variable to track longest chain in array temp
        int tempLongest = 0;
        // Traverse this table
        for (int i = 0; i < this.table.length; i++) {
            // for every position in this table, traverse its chain -- if one is present
            KVNode current = this.table[i];
            while (current != null) {
                // Create a new KVNode (deep copy)
                KVNode<K, V> newNode = new KVNode<>(current);
                // Obtain hash code of new node based on its key
                int hashedKey = newNode.getKey().hashCode();
                // Position this hash into the temp array
                int index = findIndex(hashedKey, temp.length);
                // Place new node into the temp array, taking care to chain any existing nodes
                // in the selected position [index] under the new node first.
                if (temp[index] != null) {
                    newNode.setNext(temp[index]);
                }
                // Update counts and length data
                temp[index] = newNode;
                tempLengths[index]++;
                if (tempLengths[index] > tempLongest) {
                    tempLongest = tempLengths[index];
                }
                // Move to the next node in the chain at this.table[i]
                current = current.getNext();
            }
        }
        // Replace current object with temp
        this.table = temp;
        this.loadFactor = (double) this.nodeCounter / (double) this.table.length;
        this.chainLength = tempLengths;
    } // method rehash

    /* ----------------------------- Utilities ----------------------------- */

    /**
     * Converts a hash value into an array index position. The hash value may be
     * negative (due to arithmetic overflow), so the method ensures that the return
     * value is always non-negative. Specifically, the method guarantees that 
     * O <= findIndex < length
     * 
     * @param hash int hash value to convert to array index
     * @param length int length of array to accept hash value
     * @return int O <= findIndex < length
     */
    private int findIndex(int hash, int length) {
        return ((hash < 0) ? -hash : hash) % length;
    } // method findIndex

    /** Simple descriptive statistics of current object */
    public String describe() {
        return String.format(
                FMT_ARRAY_USAGE +
                        FMT_NODES +
                        FMT_LOAD_FACTOR +
                        FMT_THRESHOLD +
                        FMT_LONGEST_CHAIN,
                STR_ARRAY_USAGE, this.tableUse, this.table.length,
                STR_NODES, this.nodeCounter,
                STR_LOAD_FACTOR, this.loadFactor,
                STR_THRESHOLD, this.threshold,
                STR_LONGEST_CHAIN, this.longestChainLength);
    } // method describe

    /** String representation */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.nodeCounter == 0) {
            sb.append(EMPTY);
        } else {
            for (int i = 0; i < this.table.length; i++) {
                sb.append(String.format("\n%05d : ", i));
                KVNode<K, V> current = this.table[i];
                while (current != null) {
                    Person person = (Person) current.getValue();
                    sb.append(String.format("%s %s %d -> ", person.getFirstName(), person.getLastName(), person.getSSN()));
                    current = current.getNext();
                }
            }
        }
        return sb.toString();
    } // method toString

    /* ----------------------- Formatting constants ------------------------ */

    private static final String FMT_FIELD_DESCRIPTION = "\n%25s: ";
    private static final String STR_ARRAY_USAGE = "Array usage";
    private static final String FMT_ARRAY_USAGE = FMT_FIELD_DESCRIPTION + "%d/%d";
    private static final String STR_NODES = "Nodes";
    private static final String FMT_NODES = FMT_FIELD_DESCRIPTION + "%d";
    private static final String STR_LOAD_FACTOR = "Load factor";
    private static final String FMT_LOAD_FACTOR = FMT_FIELD_DESCRIPTION + "%.2f";
    private static final String STR_THRESHOLD = "Threshold";
    private static final String FMT_THRESHOLD = FMT_FIELD_DESCRIPTION + "%.2f";
    private static final String STR_LONGEST_CHAIN = "Longest chain";
    private static final String FMT_LONGEST_CHAIN = FMT_FIELD_DESCRIPTION + "%d";

} // class HashTable271

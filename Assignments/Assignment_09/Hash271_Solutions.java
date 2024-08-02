public class Hash271_Solutions {

    /** Foundation array of node objects */
    Node[] foundation;
    /** Resize factor to increase the size of underlying array */
    private static final int RESIZE_BY = 2;
    /** Default size for foundation array */
    private static final int DEFAULT_SIZE = 4;

    /** Number of nodes in the structure */
    private int nodesCount;
    /** Load factor of the structure */
    private double loadFactor;
    /** Load factor threshold for rehashing */
    private int arrayUsed;

    private double threshold;
    /** Default threshold */
    private static final double DEFAULT_THRESHOLD = 0.75;

    /** Basic constructor */
    public Hash271_Solutions(int size) {
        this.foundation = new Node[size];
        this.nodesCount = 0;
        this.loadFactor = 0;
        this.arrayUsed = 0;
        this.threshold = DEFAULT_THRESHOLD;
    } // basic constructor

    /** Default constructor */
    public Hash271_Solutions() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Map an integer number to one of the positions of the underlying array. This
     * will come handy we need to find the place to chain a node.
     * 
     * @param value int to map to one of the array positions
     * @return int with the integer division remainder between the input value and
     *         the length of the array
     */
    private int computeArrayPosition(int value) {
        return value % this.foundation.length;
    } // method computeArrayPosition

    /**
     * Chain a node to the underlying array.
     * 
     * @param node Node to chain to the underlying array
     */
    public void put(Node node) {
        // Operate only if node is not null
        if (node != null) {
            // Use the node's hashcode to determine is position in
            // the underlying array
            int destination = computeArrayPosition(node.hashCode());
            if (destination < 0) destination = -destination;
            // If the position in the array is occupied by another node,
            // place that node under the new node we wish to insert
            if (this.foundation[destination] != null) {
                node.setNext(this.foundation[destination]);
            
            } else {
                this.arrayUsed++;
            }
            // Put the new node to the array position
            this.foundation[destination] = node;
            // Now that we have added a node, let's update the load factor
            this.nodesCount++;
            this.loadFactor = (double) nodesCount / (double) this.foundation.length;
            // If load factor exceeds threshold, rehash
            if (this.loadFactor > this.threshold) {
                this.rehash();
            }
        }
    } // method put

    /**
     * Rehashes the structure by doubling the size of the underlying array.
     * The method is private because it is an internal function of the object.
     * Users of this class cannot rehash the object on demand. The object
     * rehashes itself only when this.loadFactor > this.threshold.
     */
    private void rehash() {
        // Create a new array of Nodes to eventually replace this.foundation
        Node[] temp = new Node[RESIZE_BY * this.foundation.length];
        // Go through every linked list in this.foundation and place its nodes
        // to the new array:
        for (Node node : this.foundation) {
            // Traverse the list from this node
            Node current = node;
            while (current != null) {
                // Make a new node based on the current node; it's not sufficient
                // to just write Node newNode = current; this is a shallow copy
                // but we need a deep copy.
                Node newNode = new Node(current.getData());
                // Find where to place this node in the new array
                int destination = newNode.hashCode() % temp.length;
                if (destination < 0) destination = -destination;
                // if the destination is occupied, point the new node to its contents
                if (temp[destination] != null) {
                    newNode.setNext(temp[destination]);
                }
                // Place the new node at the selected destination
                temp[destination] = newNode;
                // move to the next node.
                current = current.getNext();
            }
        }
        // Now what we are done moving nodes, let's update current object
        this.foundation = temp;
        this.loadFactor = (double) nodesCount / (double) temp.length;
    } // method rehash

    /**
     * Wrapper for put(Node). Accepts a string, creates a Node object and passes it
     * to the put(Node) method.
     * 
     * @param string String to create a node for, then chain that node to the
     *               underlying array.
     */
    public void put(String string) {
        if (string != null && string.length() > 0) {
            Node node = new Node(string);
            this.put(node);
        }
    } // method put

    /** String representation of this object */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nLoad factor: %.2f, threshold %.2f\n",
                this.loadFactor, this.threshold));
        for (int i = 0; i < this.foundation.length; i++) {
            sb.append(String.format("[ %03d ]: ", i));
            Node current = this.foundation[i];
            while (current != null) {
                sb.append(String.format("<%s> ", current.toString()));
                current = current.getNext();
            }
            sb.append("\n");
        }
        return sb.toString();
    } // method toString

    /** String representation of this object */
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nLoad factor: %.2f, threshold %.2f",
                this.loadFactor, this.threshold));
        sb.append(String.format("\nArray usage: %d/%d\n",
                this.arrayUsed, this.foundation.length));
        return sb.toString();
    } // method toString


}

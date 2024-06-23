public class DynamicArray implements BasicTools {

    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 3;

    /** Constant with default scale up */
    private static final double GROWTH_FACTOR = 0.1; // 10%

    /**
     * Basic constructor for the object
     * @param size initial size of array data
     */
    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Adds a new item to array data after ensuring there is 
     * sufficient room by resizing the array if necessary.
     * @param string new item to add to array
     */
    public void add(String string) {
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            this.resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add

    /**
     * Increases the size of the underlying array by a specific factor.
     * A larger temporary array is created, contents of this.data are
     * copied over, and the temp then replaces this.data.
     */
    private void resize() {
        // +1 below for safety in case the (int) cancels the increment
        int newSize = 1 + (int)((1.0 + GROWTH_FACTOR) * this.data.length);
        String[] temp = new String[newSize];
        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    } // method resize

    /**
     * Determines if a String value is present in the underlying array
     * @param string String to search for
     * @return true if string found in array; false otherwise.
     */
    public boolean contains(String string) {
        boolean found = false;
        int i = 0;
        while (!found && i < this.position) {
            found = string.equals(this.data[i++]);
        }
        return found;
    } // method contains

    /**
     * Returns the number of times a string appears in the underlying array
     * @param string String to search for
     * @return count of occurrences.
     */
    public int countOf(String string) {
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            count = (this.data[i].equals(string)) ? count + 1 : count;
        }
        return count;
    } // method countOf

    /**
     * Adds a string to the underlying array only if the string is not
     * already present.
     * @param string String to add
     * @return true if addition was successful, false otherwise (indicating a duplicate)
     */
    public boolean addUnique(String string) {
        boolean canBeAdded = !this.contains(string);
        if (canBeAdded) {
            this.add(string);
        }
        return canBeAdded;
    } // method addUnique

    /**
     * Implements BasicTools.intersect to return true if two DynamicArray
     * objects intersect and false otherwise.
     * 
     * @param other DynamicArray object to compare to this DynamicArray object
     * @return true if these two DynamicArray objects have a common element, false otherwise
     */
    public boolean intersects(DynamicArray other) {
        /*
         * Guard statement -- it stops the method from executing if either object is
         * null or empty. A guard statement is an acceptable reason to have a second
         * return statement in a method.
         */
        if (this == null || other == null || this.position == 0 || other.position == 0) {
            return false;
        }
        /* 
         * Initialize the return variable with a comparison to the two objects we 
         * want to check for an intersection. If the two objects are the same, then
         * they intersect by definition and there is no need to compare them 
         * element by element.
         */
        boolean intersection = (this == other);
        // Prepare to traverse the underlying array of this object
        int thisIndex = 0;
        // Keep traversing this object until an intersection is found or we
        // run out of elements in it.
        while (!intersection && thisIndex < this.position) {
            // Prepare to traverse the underlying array of the other object
            int otherIndex = 0;
            // Keep traversing the other object until an intersection is found or we
            // run out of elements in it.
            while (!intersection && otherIndex < other.position) {
                // Compare the current elements between this and the other object.
                intersection = (this.data[thisIndex].equals(other.data[otherIndex]));
                // Prepare to move to the next element in the other object
                otherIndex++;
            }
            // Prepare to move to the next element in this object
            thisIndex++;
        }
        // Done!
        return intersection;
    } // method intersects

} // class DynamicArray

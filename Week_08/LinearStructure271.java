package Week_08;

public class LinearStructure271 implements Queue271<String>, Stack271<String> {

    // What's the underlying structure for this class?
    private String[] underlying;

    // How much of the underlying is used?
    private int usage;

    private static final int DEFAULT_CAPACITY = 4;

    public LinearStructure271(int capacity) {
        this.underlying = new String[capacity];
        this.usage = 0; // empty, initially
    } // basic constructor

    public LinearStructure271() {
        this(DEFAULT_CAPACITY);
    } // default constructor

    /**
     * Adds a string at the next available position in the underlying data structure
     * and updates the usage of that data structure. If usage exceed capacity, the
     * method returns a false value. If addition of the element is successful, the
     * method returns a true
     */
    public boolean add(String s) {
        boolean isThereRoom = (this.usage < this.underlying.length);
        if (isThereRoom) {
            // ok to add ... take advantage of this.usage to tell what's the
            // next available position in the underlying array
            this.underlying[this.usage++] = s;
        }
        return isThereRoom;
    } // method add

    /**
     * Removes the first element from the underlying data structure and returns it.
     * If an element is removed, then the usage of the underlying data structure is
     * reduced by one and every element in the queue moves one position closer to
     * the front. If the usage is already 0, the method returns a null value
     * and the usage remains zero.
     */
    public String remove() {
        String firstInLine = this.underlying[0];
        if (this.usage > 0) {
            // If queue is not empty, move everyone one position closer to the front
            for (int i = 1; i < this.usage; i++) {
                this.underlying[i - 1] = this.underlying[i];
            }
            this.underlying[--this.usage] = null;
        }
        return firstInLine;
    } // method remove

    public boolean push(String s) {
        boolean thereIsRoom = this.usage < this.underlying.length;
        if (thereIsRoom) {
            // Move every element one position to the right. Notice the 
            // direction of the shifts: we begin from the back and work
            // our way to the front of the array.
            for (int i = this.usage; i >=1; i--) {
                this.underlying[i] = this.underlying[i-1];
            }
            // Overwrite first position with new data
            this.underlying[0] = s;
            // Update the usage for the object
            this.usage++;
        }
        return thereIsRoom;
    } // method push

    public String pull() {
        // wraps to Queue.remove
        return this.remove();
    }
}

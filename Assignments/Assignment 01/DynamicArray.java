/*
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN.
 */
public class DynamicArray {
    
    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 10;

    /** basic constructor for the object
     * @param size initial size 
     */
    public DynamicArray(int size){
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default consructor*/
    public DynamicArray(){
        this(DEFAULT_SIZE);
    } // default constructor

    /** adds a new item to array data after ensuring there is
     * sufficent room by resizing the array if necessary 
     * @param string new item to add a array
     */
    public void add(String string){
        //Make sure there is room in array data
        if(this position == this.data.length){
            resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method aa

    /* method that resized the whole array*/
    private void resize() {
        // Create a new array with double the size
        String[] newArray = new String[this.data.length * 2];
        
        // Copy all elements from the old array to the new array
        for (int i = 0; i < this.data.length; i++) {
            newArray[i] = this.data[i];
        }
        
        // Assign the new array to the data field
        this.data = newArray;
    } // method resize

    public boolean contains(String string) {
        boolean bool = false; // Create a boolean variable to track if the string is present
        
        // Search through the array for the string provided
        for (int i = 0; i < this.position; i++) {
            if (this.data[i].equals(string)) {
                bool = true; // Update bool to true if the string is within the array
            }
        }
        return bool; // Return the result in the boolean value
    } // method contains
    
} // class DynamicArray

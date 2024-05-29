/*
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN.
 */
public class DynamicArray {
    //The underlying array for this object
    private String[] data;

    //Currently available position in array data;
    private int position;

    //Constant with default size
    private static final int DEFAULT_SIZE = 10;

    //Basic constructor
    public DynamicArray(int size){
        this.data = new String[size];
        this.position = 0;
    }
    //Default contructor
    public DynamicArray(){
        this(DEFAULT_SIZE);
    }

    /**
     * Adds a new item to array data after ensuring there is 
     * suffiecent room by resizing the arrya if necessary
     * @param string new item to add to array
     */
    public add(String string){
        //Make sure there is room in array for data
        if (this.position == this.data.length){
            resize();
        }
        //Now array has room for more elements
        this.data[this.position] = string;
        this.position++;
    }
} // class DynamicArray
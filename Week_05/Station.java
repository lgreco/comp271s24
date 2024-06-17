/**
 * Object that simulates a simple train station. These objects are used by
 * class TrainLine to simulate a train route.
 */
public class Station {

    /** The name of the train station */
    private String name; 
    /** The station immediately after */
    private Station next;

    /**
     * A simple constructor to instantiate a Station object with a given name
     * but unknown (null) next station.
     * @param name
     */
    public Station(String name) {
        this.name = name;
        this.next = null;
    } // simple constructor
} // class Station
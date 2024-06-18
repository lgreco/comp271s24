/**
 * Object that simulates a simple train station. These objects are used by
 * class TrainLine to simulate a train route.
 */
public class Station1 {

    /** The name of the train station */
    private String name; 
    /** The station immediately after */
    private Station1 next;

    /**
     * A simple constructor to instantiate a Station object with a given name
     * but unknown (null) next station.
     * @param name
     */
    public Station1(String name) {
        this.name = name;
        this.next = null;
    } // simple constructor
} // class Station
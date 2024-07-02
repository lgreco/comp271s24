/**
 * Object that simulates a simple train station. These objects are used by
 * class TrainLine to simulate a train route.
 */
public class Station {

    /** The name of the train station */
    private String name; 
    /** The station immediately after */
    private Station next;
    /** The station prior to it */
    private Station prev;

    /**
     * A simple constructor to instantiate a Station object with a given name
     * but unknown (null) next station.
     * @param name
     */
    public Station(String name) {
        this.name = name;
        this.next = null;
        this.prev = null;
    } // simple constructor

    /** Mutator for next */
    public void setNext(Station next) {
        this.next = next;
    } // method setNext

    /** Mutator for prev */ 
    public void setPrev(Station prev) {
        this.prev = prev;
    } // method setPrev

    /**
     * Predicate accessor for next
     * 
     * @return true if this station points to another station indicated by
     *         this.next; false if this.next==null.
     */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

    /** Predicate accessor for prev */
    public boolean hasPrev() {
        return this.prev != null;
    } // method hasPrev

    /** Accessor for next */
    public Station getNext() {
        return this.next;
    } // method getNext()

    /** Accessor for prev */ 
    public Station getPrev() {
        return this.prev;
    }

    /** Mutator for Name */
    public String getName() {
        return this.name;
    }
    
} // class Station
/**
 * A simple Node class (think of it as a TrainStation object) to build
 * a linked list (think of it as a TrainLine object).
 */
class Node {
    /** Data stored in the node (like the name of the train station) */
    private String data;
    /** Pointer to the next node */
    private Node next;

    /** Basic constructor */
    public Node(String data) {
        this.data = data;
        this.next = null;
    } // basic constructor

    /** Predicate accessor for next */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

    /** Accessor for next */
    public Node getNext() {
        return this.next;
    } // method getNext

    /** Mutator for next */
    public void setNext(Node next) {
        this.next = next;
    } // method setNext

    /** String representation */
    public String toString() {
        return this.data;
    } // method toString
} // class Node
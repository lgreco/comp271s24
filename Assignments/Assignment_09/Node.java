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

    /** Accessor for this.data */
    public String getData() {
        return this.data;
    } // method getData

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
        return String.format("%03d|%s", this.hashCode(), this.data);
    } // method toString, e.g. Node("Aragorn"), node.toString = 065|Aragorn

    /** Hash code */
    public int hashCode() {
        // Simplistic version: just the ASCII value of the first character of this.data
        return (this.data != null && this.data.length() > 0) ? (int) this.data.charAt(0) : 0;
    } // method hashCode

} // class Node
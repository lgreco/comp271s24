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
    } // method toString, e.g. Node("Arjun"), node.toString = 065|Arjun

    /** Hash code */
    public int hashCode() {
        /*
        int sum = 0;
        if (this.data != null && this.data.length() > 0) {
            for (int i=0; i < this.data.length(); i++) {
                sum += (int) this.data.charAt(i);
            }
        }
        return sum; */
        return (this.data != null && this.data.length() > 0) ? (int) this.data.charAt(0) : 0;
        /*
         * if (this.data != null && this.data.length() > 0) {
         *   return (int) this.data.charAt(0);
         * } else {
         *   return 0;
         * }
         */
    }

} // class Node
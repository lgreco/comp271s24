
/**
 * 
 * 
 * Write a singly-linked list class with simple node objects that contain a
 * String `data` and a `Node next`. You'll have to write class Node as well.
 * 
 * In your linked list class, write the following methods
 * 
 * **`void addNode(Node node)`** to **append** the given node to the linked
 * list.
 * 
 * **`void addNode(String data)`** to append a node with the string `data` to
 * the linked list.
 * 
 * A method of your own naming and type (including `void`) that reverses the
 * linked list -- for now let's call it `method1`, but you should find a better,
 * more descriptive name.
 * 
 * A method of your own naming and type (including `void`) that removes any
 * duplicate nodes from the linked list -- for now let's call it `method2`, but
 * you should find a better, more descriptive name.
 * 
 * 
 * 
 * Your linked list object may have one and only one attribute.
 * 
 * 
 * If your `method1` works correctly and your initial linked list is, for
 * example,
 * 
 * ```
 * A -> B -> C -> D -> E -> F -> G -> null
 * ```
 * 
 * then the invocation of your method will return
 * 
 * ```
 * G -> F -> E -> D -> C -> B -> A -> null
 * ```
 * 
 * 
 * If your `method2` works correctly and your initial linked list is, for
 * example,
 * 
 * ```
 * A -> B -> B -> B -> B -> C -> C -> null
 * ```
 * 
 * then the invocation of your method will return
 * 
 * ```
 * A -> B -> C -> null
 * ```
 */
public class LinkedList_C {

    /** Inner class with Node object; for easy self-contained access. */
    class Node {
        String data;
        Node next;

        /** Basic contructor */
        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        /** Setter for next */
        public void setNext(Node node) {
            this.next = node;
        }

        /** Getter for next */
        public Node getNext() {
            return this.next;
        }

        /** Boolean getter for next */
        public boolean hasNext() {
            return this.next != null;
        }

        /** String representation */
        public String toString() {
            return String.format("[%s]", data);
        }

        /** Getter for data */
        public String getData() {
            return this.data;
        }
    } // inner class Node

    /**
     * This linked list class is allowed one and only one attribute, the head node.
     */
    Node head;

    /** Getter for head */
    public Node getHead() {
        return head;
    }

    /** Add a node to the list, by finding its last node every time */
    void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    } // method addNode

    /** Create a new node with given string and add it to the list */
    void addNode(String data) {
        addNode(new Node(data)); // wrap to addNode(Node)
    } // method addNode

    /**
     * Reverses a linked list and returned a new linked list with the nodes in
     * reverse order. The method is based on auxiliary method addAsHead to place new
     * nodes at the beginning of the list. This is `method1` for Problem C.
     * 
     * @return a linked list with the nodes of the present object in reverse order.
     *         If the present object is empty (this.head==null) the method also
     *         returns a new list with a null head.
     */
    public LinkedList_C reverse() {
        LinkedList_C reversed = new LinkedList_C();
        Node current = this.head;
        while (current != null) {
            Node newNode = new Node(current.getData());
            reversed.addAsHead(newNode);
            current = current.getNext();
        }
        return reversed;
    } // method reverse

    /**
     * Method to insert a node at the head of the list
     * 
     * @param node
     */
    public void addAsHead(Node node) {
        if (this.head == null) {
            this.addNode(node);
        } else {
            node.setNext(this.head);
            this.head = node;
        }
    } // method addAsHead

    /**
     * In-place removal of duplicate nodes
     */
    public void removeDuplicates() {
        LinkedList_C temp = new LinkedList_C();
        if (this.head != null) {
            Node current = this.head;
            while (current != null) {
                if (!temp.contains(current)) {
                    Node newNode = new Node(current.getData());
                    temp.addNode(newNode);
                }
                current = current.getNext();
            }
        }
        this.head = temp.getHead();
    } // method removeDuplicates

    /**
     * Determine if present object contains a given node
     * 
     * @param node Node to search for in linked list
     * @return true if node with same contents is found in the list; false otherwise
     *         or if list is empty.
     */
    public boolean contains(Node node) {
        boolean found = false;
        if (this.head != null) {
            Node current = this.head;
            while (!found && current != null) {
                found = current.getData().equals(node.getData());
                current = current.getNext();
            }
        }
        return found;
    } // method contains

    /** Textual representation for the present object */
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        Node current = head;
        while (current != null) {
            sb.append(String.format("%s -> ", current.getData()));
            current = current.getNext();
        }
        return sb.toString();
    } // method toString

    /** Driver code */
    public static void main(String[] args) {
        // Setup the demo object
        LinkedList_C demo = new LinkedList_C();
        // Populate demo with triplicates
        for (int ascii = 'A'; ascii <= 'F'; ascii++) {
            demo.addNode(String.valueOf((char) ascii));
            demo.addNode(String.valueOf((char) ascii));
            demo.addNode(String.valueOf((char) ascii));
        }
        // What does demo look like?
        System.out.println(demo);
        // Remove dups and print
        demo.removeDuplicates();
        System.out.println(demo);
    } // main
}
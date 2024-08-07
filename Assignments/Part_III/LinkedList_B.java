
/**
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
 * A method of your own naming and type (including `void`) that takes the last
 * node and makes it the head node of the list -- for now let's call it
 * `method1`, but you should find a better, more descriptive name.
 * 
 * Another method of your own naming and type (including `void`) that partitions
 * the list into two lists around a given value. One list has all the nodes that
 * are less than the given value. The other, all the nodes that are greater or
 * equal to the given value. Let's call it `method2`, but you should find a
 * better, more descriptive name.
 * 
 * Your linked list object may have one and only one attribute.
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
 * B -> C -> D -> E -> F -> G -> A -> null
 * ```
 * 
 * The next invocation will return
 * 
 * ```
 * C -> D -> E -> F -> G -> A -> B -> null
 * ```
 * 
 * and so on.
 * 
 * If your `method2` works correctly, and your linked list is
 * 
 * ```
 * C -> D -> E -> F -> G -> A -> B -> null
 * ```
 * 
 * then partitioning the list around `F` should return these two lists:
 * 
 * ```
 * C -> D -> E -> A -> B -> null
 * F -> G -> null
 * ```
 * 
 * `method2` should **not** return an array.
 */
public class LinkedList_B {

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
     * Inner class for list partitions. This is required for `method2` in Problem B,
     * so that the partitioning method can return a single value, ie, an object of
     * this class, with the two partitioned lists as its fields.
     */
    class ListPartitions {
        LinkedList_B leftPartition;
        LinkedList_B rightPartition;

        /** Full constructor */
        public ListPartitions(LinkedList_B left, LinkedList_B right) {
            this.rightPartition = right;
            this.leftPartition = left;
        } // full constructor

        /** Accessor for rightPartition */
        public LinkedList_B getRightPartition() {
            return this.rightPartition;
        }

        /** Accessor for left partition */
        public LinkedList_B getLeftPartition() {
            return this.leftPartition;
        }

        /** String representation */
        public String toString() {
            return String.format("\nLeft partition: %s\nRight partition: %s", leftPartition.toString(),
                    rightPartition.toString());
        }
    } // inner class ListPartitions

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
     * This is "method1" for Problem B. It takes the last node and makes it the head
     * node of the list.
     * 
     */
    public void rotate() {
        // If list is empty (head==null) or has only one node (head.next == null) take
        // no action.
        if (this.head != null && this.head.hasNext()) {
            /*
             * Traverse the list to find the last two nodes. The last node becomes head of
             * the list, and the second-to-last becomes the new last node.
             */
            Node current = this.head;
            while (current.hasNext() && current.getNext().hasNext()) {
                current = current.getNext();
            }
            // Loop stops when current is at the penultimate (second-to-last) node and
            // therefore current.getNext is the ultimate (last) node.
            Node last = current.getNext();
            // Make the second-to-last node the new last node by setting its next to null
            current.setNext(null);
            // Take the last node, connect it to head, and designate it as new head
            last.setNext(this.head);
            this.head = last;
        }
    } // method rotate

    /**
     * This is "method2" for Problem B. Partitions the list into two lists around a
     * given value. One list has all the nodes that are less than the given value.
     * The other, all the nodes that are greater or equal to the given value.
     * 
     * @param data the value to split the list arond
     * @return a ListPartitions object that contains the two partitions.
     */
    public ListPartitions partition(String partitionValue) {
        LinkedList_B left = new LinkedList_B();
        LinkedList_B right = new LinkedList_B();
        // Traverse the current list, copying notes to the left and right partitions as
        // we move through.
        Node current = this.head;
        while (current != null) {
            String data = current.getData();
            // It's unlikely that a node will have a null string but just in case, let's
            // check and skip nodes with no data.
            if (data != null) {
                Node newNode = new Node(data);
                if (data.compareTo(partitionValue) <= 0) {
                    left.addNode(newNode);
                } else {
                    right.addNode(newNode);
                }
            }
            current = current.getNext();
        }
        return new ListPartitions(left, right);
    } // method partition

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
        LinkedList_B demo = new LinkedList_B();
        // Populate demo with a few strings
        for (int ascii = 'A'; ascii <= 'F'; ascii++) {
            demo.addNode(String.valueOf((char) ascii));
        }
        // What does demo look like?
        System.out.println(demo);
        // Rotate and print a few times
        demo.rotate();
        ;
        System.out.print(demo);
        demo.rotate();
        System.out.print(demo);
        System.out.println(demo.partition("C"));
    } // main
}
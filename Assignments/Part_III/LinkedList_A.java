
/**
 * Write a singly-linked list class with simple node objects that contain a
 * String `data` and a `Node next`. You'll have to write class Node as well.
 * 
 * In your linked list class, write the following methods:
 * 
 * **`void addNode(Node node)`** to **append** the given node to the linked
 * list.
 * 
 * **`void addNode(String data)`** to append a node with the string `data` to
 * the linked list.
 * 
 * A method of your own naming and type (including `void`) that splits the
 * linked list object into a given number of linked lists and returns all of
 * them.
 * 
 * Additional methods to print the linked list object (`toString()`) an well as
 * a method to print the result of the splitting. Notice that the method doing
 * the spliting should not do any printing.
 * 
 * Your linked list object may have one and only one attribute.
 * 
 * If your splitting method works correctly and your initial linked list is, for
 * example,
 * 
 * ```
 * A -> B -> C -> D -> E -> F -> G -> null
 * ```
 * 
 * then splitting it into say 3 linked lists would produce the following
 * 
 * ```
 * A -> B -> null
 * C -> D -> null
 * E -> F -> G -> null
 * ```
 * 
 * The resulting linked lists must be of even length, as much as possible. In
 * the example above, we divided a linked list with 7 nodes into 3 lists of 2,
 * 2, and 3 elements respectively. Therefore, the last linked list may,
 * sometimes, have a few more elements than the rest of the lists.
 */
public class LinkedList_A {

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
     * The method for Problem A. It splits the present object into multiple linked
     * lists and returns the segments as an array of linked lists.
     * 
     * @param numberOfSegments int number of segments >0 to partition present object
     *                         to. If numberOfSegments == 0 method returns null. If
     *                         numberOfSegments > number of nodes,
     *                         then method behaves as if numberOfSegments = 1.
     * @return array of linked lists with numberOfSegments elements.
     */
    LinkedList_A[] splitIn(int numberOfSegments) {
        // Prepare the return object
        LinkedList_A[] splits = null;
        // Guard statement. If <= 0, skip straight to the end and return null
        if (numberOfSegments > 0) {
            // Count of nodes is provided by auxiliary method countNodes
            int numberOfNodes = this.countNodes();
            /*
             * If there are fewer nodes than segments to split the linked list, we'll end up
             * with an array of mostly null elements, except for the last element that will
             * contain the whole list. That's because the size of the array is determined by
             * the integer division numberOfNodes/numberOfSegments. When
             * numberOfNodes<numberOfSegments, the integer fraction is 0. To avoid wasting
             * array space, we handle this special case by returning an 1-element array with
             * the entire list in it. We do the same if numberOfNodes == numberOfSegments
             * because we "split" the array in one segment only.
             */
            if (numberOfNodes <= numberOfSegments) {
                splits = new LinkedList_A[1];
                splits[0] = this;
            } else {
                // There are more nodes than segments. So each segmented linked list
                // will have at least one node. These segments will now be placed in array.
                splits = new LinkedList_A[numberOfSegments];
                // Determine number of nodes per segment;
                int nodesPerSplit = numberOfNodes / numberOfSegments;
                /*
                 * Populate the return array splits[] by traversing the present linked list,
                 * counting nodes. Every so many nodes (specified by nodesPerSplit) create a
                 * new, temporary linked list with the current node as its head. Then add as
                 * many nodes to temp as specified in nodesPerSplit, and assign temp to the
                 * splits[] position. Reset the counters and continue until we run out of nodes
                 * in the present object or out of positions in splits[].
                 */
                Node current = head;
                // index for array splits[]
                int index = 0;
                while (current != null && index < numberOfSegments) {
                    LinkedList_A temp = new LinkedList_A();
                    // Count the number of nodes per segment.
                    int localCount = 0;
                    while (localCount < nodesPerSplit) {
                        // We need a deep copy of the current node; if we try to simply
                        // temp.addNode(current) things will get messy; therefore we must
                        // create a completely new node with the same data as the current.
                        Node newNode = new Node(current.getData());
                        temp.addNode(newNode);
                        current = current.getNext();
                        localCount++;
                    }
                    // List temp has now as many nodes as we need per segment. Let's assign
                    // it to the current position in array splits[] and advance the index.
                    splits[index++] = temp;
                }
                /*
                 * The while loop above ends either because we run out of nodes (current==null)
                 * or because we filled all the positions in array splits[] (i==k). If the loop
                 * ends because i==k then there may still be unprocessed nodes (current !=
                 * null). In this case we append current to the last splits[] element which is
                 * in the last position.
                 */
                if (current != null) {
                    splits[numberOfSegments - 1].addNode(current);
                }
            }
        }
        // Done.
        return splits;
    } // method splitIn

    /**
     * Auxiliary method that counts the nodes in a linked list object by traversing
     * them.
     * 
     * @return int with count of nodes. If list has no head, return 0.
     */
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    } // method countNodes

    /**
     * String representation for an array of linked lists. We could always write it
     * as a Arrays.toString(arrayOfLL), since both the linkedlist and the node
     * classes implement the toString method. But the output will be kind of messy.
     * Instead we produce a more nicely formatted string for printing out.
     * 
     * @param splits array of linked lists
     * @return String with nice textual representation of that array
     */
    String splitsToString(LinkedList_A[] splits) {
        StringBuilder sb = new StringBuilder();
        if (splits != null) {
            for (int i = 0; i < splits.length; i++) {
                sb.append(String.format("\n[%03d]: ", i));
                Node current = splits[i].getHead();
                while (current != null) {
                    sb.append(String.format("%s -> ", current.toString()));
                    current = current.getNext();
                }
            }
        }
        return sb.toString();
    } // method splitsToString

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
        LinkedList_A demo = new LinkedList_A();
        // Populate demo with 26 strings
        for (int ascii = 'A'; ascii <= 'Z'; ascii++) {
            demo.addNode(String.valueOf((char) ascii));
        }
        // What does demo look like?
        System.out.println(demo);
        // Split demo in segments and print them
        LinkedList_A[] splits = demo.splitIn(10);
        System.out.println(demo.splitsToString(splits));
    } // main
}
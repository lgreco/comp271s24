
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedListSolution implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    /**
     * Adds a string at the next available position in the underlying data structure
     * and updates the usage of that data structure. If usage exceed capacity, the
     * method returns a false value. If addition of the element is successful, the
     * method returns a true.
     * 
     * LOCAL IMPLEMENTATION NOTE: since we are using a linked list as the underlying
     * data structure, capacity is no longer an issue. A linked list can accept an
     * indefinite number of nodes. Its size is only limited by the amount of memory
     * available in the system.
     *
     * The next avaiable position in a linked list is always after the last node.
     * 
     * @param s String to add
     * @return true is room for string; false otherwise
     */
    public boolean add(String string) {
        boolean success = (string != null && string.length() > 0);
        if (success) {
            Node newNode = new Node(string);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.setNext(newNode);
                this.tail = newNode;
            }
        }
        return success;
    } // method add

    /**
     * Removes the first element from the underlying data structure and returns it.
     * If an element is removed, then the usage of the underlying data structure is
     * reduced by one and every element in the queue moves one position closer to
     * the front. If the usage is already 0, the method returns a null value
     * and the usage remains zero.
     * 
     * LOCAL IMPLEMENTATION NOTE: In a linked list, the first element is always
     * identified as this.head.
     * 
     * @return String in the front of the underlying data structure.
     */
    public String remove() {
        String removed = null;
        if (this.head != null) {
            removed = this.head.getData();
            this.head = this.head.getNext();
            this.tail = (this.head == null) ? null : this.tail;
        }
        return removed;
    } // method removed

    /**
     * Inserts an element at the front of the underlying data structure. All
     * existing elements are first moved one position closer to the end of
     * underlying data structure. Then the new element is placed at the
     * front position. If the underlying data structure is full, the method
     * returns false to indicate nothing was inserted; otherwise true. When
     * inserting something successfully, usage++
     * 
     * 
     * LOCAL IMPLEMENTATION NOTE: In a linked list, the first element is always
     * identified as this.head. A new insertion prior to it requires that we
     * point this.head to the new node.
     * 
     * @param e
     * @return
     */
    public boolean push(String string) {
        boolean success = (string != null && string.length() > 0);
        if (success) {
            Node newNode = new Node(string);
            newNode.setNext(this.head);
            this.tail = (this.head == null) ? newNode : this.head;
            this.head = newNode;
        }
        return success;
    } // method push

    /**
     * Removes and returns what's in the front of the underlying data structure,
     * including nulls. Null means that structure is empty. Otherwise the first
     * element is returned and the usage is adjusted accordingly. Successful
     * removals cause remaining elements to move one position closer to the front.
     * 
     * LOCAL IMPLEMENTATION NOTE: In a linked list, the last element is always
     * identified as this.tail.
     * 
     * @return
     */
    public String pull() {
        return this.remove();
    } // method pull

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            sb.append("Empty list.");
        } else {
            Node current = this.head;

            // Append the first node outside of the loop to avoid unnecessary checks in the
            // loop
            sb.append(String.format("[%s]", current.getData()));

            // Traverse the list from the second node onwards
            while (current.hasNext()) {
                current = current.getNext();
                sb.append(String.format(" -> [%s]", current.getData()));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleLinkedListSolution demoQueue = new SimpleLinkedListSolution();
        SimpleLinkedListSolution demoStack = new SimpleLinkedListSolution();
        demoQueue.add("A");
        demoQueue.add("B");
        demoQueue.add("C");
        
        boolean queueWorks = demoQueue.remove().equals("A") &&
                demoQueue.remove().equals("B") &&
                demoQueue.remove().equals("C") &&
                demoQueue.remove() == null;

        demoStack.push("A");
        demoStack.push("B");
        demoStack.push("C");

        boolean stackWorks = demoStack.pull().equals("C") &&
                demoStack.pull().equals("B") &&
                demoStack.pull().equals("A") &&
                demoStack.pull() == null;

        System.out.println(queueWorks);
        System.out.println(stackWorks);
    }

} // class SimpleLinkedList

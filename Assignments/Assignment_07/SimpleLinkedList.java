
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    public SimpleLinkedList() {
        // Initialize head and tail to null; an empty list
        this.head = null;
        this.tail = null;
    
    }
    //Stack method
    public boolean push (String e) {
        // Create a new node with the given data 
        Node newNode = new Node(e);
        // If  this list is empty 
        if(head == null) {
            // Set both head and tail to the new node 
            head = newNode;
            tail = newNode;
        }else {
            // Otherwise, insert the new node at the front  
            newNode.setNext(head);
            head = newNode;
        }    
        return true;
        }
 
    public String pull() {
        if (head == null) {
            return null;
        }
        // Store the data of the head node
        String data = head.toString();
        head = head.getNext();
        // if the list is empty update to null
        if (head == null) {
            tail = null; 
        }
        // return the removed node
        return data;  
    }

    //Queue method 
    public boolean add(String e) {
        Node newNode = new Node(e); 
        // if the list is empty 
        if (tail == null){
            // set head and tail to new node
            head = newNode;
            tail = newNode;
        } else {
            // if not add the node to the end
            tail.setNext(newNode);
            tail = newNode;
        }
        // return true when added 
        return true;
    }

    public String remove() {
        if (head == null) { // if the list is empty
            return null; // return null nothing is removed
        }

            String data = head.toString();
            head = head.getNext(); // head pointer to the next node

            // if the list is empty after removing update the tail
            if (head == null) { 
                tail = null;
            }
            return data;
    }
    public static void main(String[] args) {

        SimpleLinkedList demoQueue = new SimpleLinkedList();
        SimpleLinkedList demoStack = new SimpleLinkedList();

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


}
class Node {

    private String data;

    private Node next;

    public Node(String data) {
        this.data = data; 
        this.next = null;
    }

    public boolean hasNext() {
        // return true if the next node is not null otherwise false 
        return this.next != null; 
    }

    public Node getNext() {
        return this.next; //next node
    }
    public void setNext(Node next) {
        this.next = next; //set the next node
    }
    public String toString() {
        return this.data;
    }
} // class SimpleLinkedList

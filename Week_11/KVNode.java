public class KVNode<K, V> {

    /**
     * This object for this.key must have an int hashCode() function implemented.
     */
    private K key;
    private V value;
    private KVNode<K, V> next;

    /** Partial constructor based on K,V pair */
    public KVNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    } // partial constructor with K,V pair

    /** Partial constructor based on KVNode */
    public KVNode(KVNode<K, V> node) {
        this(node.getKey(), node.getValue());
    } // partial constructor with KVNode

    /* ---------------------- Mutators and Accessors ----------------------- */

    public void setNext(KVNode<K, V> next) {
        this.next = next;
    } 

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public KVNode<K, V> getNext() {
        return this.next;
    }
} // class KVNode

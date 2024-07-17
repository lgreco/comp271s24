

public interface Stack271<E> { // for any class E eg String, Person, etc

    /**
     * Inserts an element at the front of the underlying data structure. All
     * existing elements are first moved one position closer to the end of 
     * underlying data structure. Then the new element is placed at the 
     * front position. If the underlying data structure is full, the method
     * returns false to indicate nothing was inserted; otherwise true. When
     * inserting something successfully, usage++
     * @param e
     * @return
     */
    boolean push(E e);

    /**
     * Removes and returns what's in the front of the underlying data structure,
     * including nulls. Null means that structure is empty. Otherwise the first
     * element is returned and the usage is adjusted accordingly. Successful 
     * removals cause remaining elements to move one position closer to the front.
     * @return
     */
    E pull();
}

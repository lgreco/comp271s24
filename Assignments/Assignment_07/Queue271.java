
public interface Queue271<E> { // E = String or E = Integer or E = Person
    /**
     * Adds a string at the next available position in the underlying data structure
     * and updates the usage of that data structure. If usage exceed capacity, the
     * method returns a false value. If addition of the element is successful, the
     * method returns a true.
     * 
     * @param s String to add
     * @return true is room for string; false otherwise
     */
    boolean add(E e);

    /**
     * Removes the first element from the underlying data structure and returns it.
     * If an element is removed, then the usage of the underlying data structure is
     * reduced by one and every element in the queue moves one position closer to
     * the front. If the usage is already 0, the method returns a null value
     * and the usage remains zero.
     * 
     * @return String in the front of the underlying data structure.
     */
    E remove();
} // interface Queue271

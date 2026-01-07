public class MySinglyLinkedList<T> implements MyList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // fields
    private Node<T> head = null;
    private int size;

    /**
     * Adds an element to the end of the linked list
     * <p>
     * Time complexity: O(n) because it traverses the list to find the last node.
     *
     * @param element the element to be added to the list
     * @return true if the element was added successfully
     */
    @Override
    public boolean add(T element) {
        // create a new node with the element
        Node<T> newNode = new Node<>(element);

        // if the list is empty, set the new node as head
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        // traverse to the last node
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // append the new node
        temp.next = newNode;
        size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified object from the linked list
     * <p>
     * Time complexity: O(n) as it may need to traverse the entire list
     * to find the element to remove
     *
     * @param object the element to be removed from the list
     * @return true if the element was found and removed, false otherwise
     */
    @Override
    public boolean remove(Object object) {
        if (head == null) return false;

        // if the head itself is the match, remove it
        if (head.data.equals(object)) {
            head = head.next;
            size--;
            return true;
        }

        // traverse until the object to remove is found
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(object)) {
                temp.next = temp.next.next; // change pointer to skip over the element
                size--;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * Removes the element at the specified position in the linked list
     * <p>
     * Time complexity: O(n) as it may need to traverse the list to the given index.
     *
     * @param index the position of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if index < 0 or >= size
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            T removed = head.data;
            head = head.next;
            size--;
            return removed;
        }

        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        T removed = temp.next.data;
        temp.next = temp.next.next;
        size--;

        return removed;
    }

    /**
     * Returns the element at the specified position in the linked list
     * <p>
     * Time complexity: O(n) as it may need to traverse the list up to the given index
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range {@code (index < 0 || index >= size)}
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.next.data;
    }

    /**
     * Returns the number of elements in the linked list
     * <p>
     * Time complexity: O(1)
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks whether the linked list is empty
     * <p>
     * Time complexity: O(1)
     *
     * @return true if the list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Removes all elements from the linked list
     * <p>
     * Time complexity: O(1)
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }
}

package doublyLinkedList;
// Assignment: 5
// Author: Or Adar, ID: 305468506
/**
 * The DoublyLinkedList class represents a doubly linked list implementation of the List interface.
 * It provides methods to add, remove, and manipulate elements in the list.
 *
 * @param <T> the type of elements stored in the list
 */

public class DoublyLinkedList <T> implements List<T> {
    Node<T> listStart;
    Node<T> listEnd;

    /**
     * Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.listStart = new Node<T>(null);
        this.listEnd = listStart;
    }
    /**
     * Checks if the doubly linked list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (listStart.getData() == null) {
            return true;
        }
        return false;
    }
    /**
     * Returns the number of elements in the doubly linked list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        int count = 0;
        Node<T> pointer = listStart;
        while (pointer != null && pointer.getData() != null) {
            count++;
            pointer = pointer.nextNode;
        }
        return count;
    }
    /**
     * Adds an element to the beginning of the doubly linked list.
     *
     * @param data the element to be added
     */
    @Override
    public void addFirst(T data) {
        if (isEmpty()) {
            listStart.setData(data);
        } else {
            Node<T> node = new Node<>(data);
            node.setNextNode(listStart);
            listStart.setPrevNode(node);
            listStart = node;
        }
    }

    /**
     * Adds an element to the end of the doubly linked list.
     *
     * @param data the element to be added
     */
    @Override
    public void addLast(T data) {
        if (isEmpty()) {
            listEnd.setData(data);
        } else {
            Node<T> node = new Node<>(data);
            node.setPrevNode(listEnd);
            listEnd.setNextNode(node);
            listEnd = node;
        }
    }
    /**
     * Removes the first occurrence of the specified element from the doubly linked list, if present.
     *
     * @param data the element to be removed
     * @return the removed element, or null if the element is not found
     */
    @Override
    public T remove(T data) {
        if (!contains(data))
            return null;
        if (size() == 1) {
            clear();
            return data;
        }
        Node<T> p1 = listStart.getPrevNode();
        Node<T> p2 = listStart;
        if (listStart.getData().equals(data)) {
            p2 = listStart.getNextNode();
            p2.setPrevNode(null);
            listStart = p2;
            return data;
        }
        while (p2 != null && p2.getData() != null) {
            if (p2.getData().equals(data)) {
                p2 = p2.getNextNode();
                break;
            } else {
                if (p1 == null) {
                    p1 = listStart;
                    p2 = p2.getNextNode();
                } else {
                    p1 = p1.getNextNode();
                    p2 = p2.getNextNode();
                }
            }
        }
        if (p2 == null) {
            p1 = listEnd.getPrevNode();
            p1.setNextNode(null);
            listEnd = p1;
            return data;
        }
        p1.setNextNode(p2);
        p2.setPrevNode(p1);
        return data;
    }
    /**
     * Clears all elements from the doubly linked list, making it empty.
     */
    @Override
    public void clear() {
        this.listStart = new Node<T>(null);
        this.listEnd = listStart;
    }
    /**
     * Checks if the doubly linked list contains the specified element.
     *
     * @param data the element to be checked
     * @return true if the element is found, false otherwise
     */
    @Override
    public boolean contains(T data) {
        Node<T> pointer = listStart;
        while (pointer != null && pointer.getData() != null) {
            if (pointer.getData().equals(data))
                return true;
            pointer = pointer.getNextNode();
        }
        return false;
    }
    /**
     * Prints the elements of the doubly linked list in forward order.
     */
    @Override
    public void printForward() {
        Node<T> pointer = listStart;
        while (pointer != null && pointer.getData() != null) {
            System.out.print(pointer.getData() + " ");
            pointer = pointer.getNextNode();
        }
    }
    /**
     * Prints the elements of the doubly linked list in reverse order.
     */
    @Override
    public void printBackwards() {
        Node<T> pointer = listEnd;
        while (pointer != null && pointer.getData() != null) {
            System.out.print(pointer.getData() + " ");
            pointer = pointer.getPrevNode();
        }
    }
}

package doublyLinkedList;
// Assignment: 5
// Author: Or Adar, ID: 305468506
/**
 * The Node class represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    T data;
    Node<T> nextNode;
    Node<T> prevNode;

    /**
     * Constructs a node with the specified data.
     *
     * @param data the data to be stored in the node
     */
    public Node(T data) {
        this.data = data;
        nextNode = null;
        prevNode = null;
    }

    /**
     * Returns the data stored in the node.
     *
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data stored in the node.
     *
     * @param data the data to be set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the next node in the linked list.
     *
     * @return the next node in the linked list
     */
    public Node<T> getNextNode() {
        return nextNode;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param nextNode the next node to be set
     */
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Returns the previous node in the linked list.
     *
     * @return the previous node in the linked list
     */
    public Node<T> getPrevNode() {
        return prevNode;
    }

    /**
     * Sets the previous node in the linked list.
     *
     * @param prevNode the previous node to be set
     */
    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }
}


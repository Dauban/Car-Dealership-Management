package doublyLinkedList;
// Assignment: 5
// Author: Or Adar, ID: 305468506
public interface List<T> {
    boolean isEmpty();
    int size();
    void addFirst(T data);
    void addLast(T data);
    T remove(T data);
    void clear();
    boolean contains(T data);
    void printForward();
    void printBackwards();

}

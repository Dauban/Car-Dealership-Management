package doublyLinkedList;
// Assignment: 5
// Author: Or Adar, ID: 305468506
/**
 * The Menu enum represents a set of menu options for a DoublyLinkedList.
 */
public enum Menu {
    ISEMPTY,
    SIZE,
    ADDFIRST,
    ADDLAST,
    REMOVE,
    CLEAR,
    CONTAINS,
    PRINTFORWARD,
    PRINTBACKWARD;

    /**
     * Prints the menu options.
     */
    public static void printMenu() {
        System.out.println("Choose the method you want to apply:");
        for (Menu method : Menu.values()) {
            System.out.println(method.ordinal() + ": " + method);
        }
    }
}

package carDealership;
// Assignment: 5
// Author: Or Adar, ID: 305468506
/**
 * The Menu enum represents the available options in the program's menu.
 */
public enum Menu {
    SHOWEMPLOYEELIST,
    UNSOLDCARS,
    CARSALE,
    ADDACAR,
    ENDPROGRAM;

    /**
     * Prints the menu options to the console.
     */
    public static void printMenu() {
        System.out.println("Menu:");
        for (Menu choice : Menu.values()) {
            System.out.println(choice.ordinal() + 1 + ": " + choice);
        }
    }
}


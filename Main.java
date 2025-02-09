package doublyLinkedList;

import java.util.Scanner;
// Assignment: 5
// Author: Or Adar, ID: 305468506
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int input,choice;
        DoublyLinkedList<Integer> list=new DoublyLinkedList<>();
        while(true){
            Menu.printMenu();
            choice=scan.nextInt();
            switch(choice){
                case 0-> System.out.println(list.isEmpty());
                case 1-> System.out.println(list.size());
                case 2->{
                    System.out.println("Which input would you like to insert?");
                    input=scan.nextInt();
                    list.addFirst(input);
                }
                case 3->{
                    System.out.println("Which input would you like to insert?");
                    input=scan.nextInt();
                    list.addLast(input);
                }
                case 4->{
                    System.out.println("Which input would you like to remove?");
                    input=scan.nextInt();
                    list.remove(input);
                }
                case 5->list.clear();
                case 6->{
                    System.out.println("Which input would you like to check?");
                    input=scan.nextInt();
                    System.out.println(list.contains(input));
                }
                case 7->list.printForward();
                case 8->list.printBackwards();
                default->choice=-1;
            }
            if (choice==-1)
                break;
        }
    }
}
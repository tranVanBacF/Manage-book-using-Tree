/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bac
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BookList b = new BookList();
        Validate v = new Validate();
        int k;
        while (true) {
            displayMenu();
            int choice = v.checkchoice("Your Choice: ");
            switch (choice) {
                case 1:
                    b.loadFile("book.txt");
                    b.traversal();
                    break;
                case 2:
                    b.addEnd();
                    b.traversal();
                    break;
                case 3:
                    b.traversal();
                    break;
                case 4:
                    b.saveFile("book.txt");
                    break;
                case 5:
                    if (b.searchByBcode("B03") != null) {
                        System.out.println("exist");
                    } else {
                        System.out.println("doesn't exist");
                    }
                    break;
                case 6:
                    b.deleByBcode("B03");
                    b.traversal();
                    break;
                case 7:
                    b.sortByBcode();
                    b.traversal();
                    break;
                case 8:
                    b.addFirst();
                    b.traversal();
                    break;
                case 9:
                    b.insertAfterPos(3, new Book("B111", "Morning   ", 12, 8, 22.1));
                    b.traversal();
                    break;
                case 10:
                    b.delePos(3);
                    b.traversal();
                    break;

            }
        }
    }

    public static void displayMenu() {
        System.out.println("Book list:\n"
                + "1.1.      Load data from file\n"
                + "1.2.      Input & add to the end\n"
                + "1.3.      Display data\n"
                + "1.4.      Save book list to file\n"
                + "1.5.      Search by bcode\n"
                + "1.6.      Delete by bcode\n"
                + "1.7.      Sort by bcode\n"
                + "1.8.       Input & add to beginning\n"
                + "1.9.      Add after position  k\n"
                + "1.10.     Delete position k\n");

    }

}

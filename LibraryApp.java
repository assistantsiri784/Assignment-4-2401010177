package casiignment4;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CITY LIBRARY DIGITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Sort Books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> manager.addBook(sc);
                case 2 -> manager.addMember(sc);
                case 3 -> manager.issueBook(sc);
                case 4 -> manager.returnBook(sc);
                case 5 -> manager.searchBooks(sc);
                case 6 -> manager.sortBooks();
                case 7 -> {
                    manager.saveToFile();
                    System.out.println("Exiting... Data saved.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}


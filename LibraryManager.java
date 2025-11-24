package casiignment4;

import java.io.*;
import java.util.*;

public class LibraryManager {
    private Map<Integer, Book> books;
    private Map<Integer, Member> members;

    private static final String BOOKS_FILE = "books.txt";
    private static final String MEMBERS_FILE = "members.txt";

    private int nextBookId = 1;
    private int nextMemberId = 1;

    public LibraryManager() {
        books = new HashMap<>();
        members = new HashMap<>();
        loadFromFile();
    }

    // ---------------- ADD BOOK ----------------
    public void addBook(Scanner sc) {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        Book book = new Book(nextBookId, title, author, category, false);
        books.put(nextBookId, book);

        System.out.println("Book added successfully with ID: " + nextBookId);

        nextBookId++;
        saveToFile();
    }

    // ---------------- ADD MEMBER ----------------
    public void addMember(Scanner sc) {
        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter member email: ");
        String email = sc.nextLine();

        Member member = new Member(nextMemberId, name, email);
        members.put(nextMemberId, member);

        System.out.println("Member added successfully with ID: " + nextMemberId);

        nextMemberId++;
        saveToFile();
    }

    // ---------------- ISSUE BOOK ----------------
    public void issueBook(Scanner sc) {
        System.out.print("Enter Member ID: ");
        int memberId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Book ID: ");
        int bookId = Integer.parseInt(sc.nextLine());

        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued!");
            return;
        }

        book.markAsIssued();
        member.addIssuedBook(bookId);

        System.out.println("Book issued successfully!");

        saveToFile();
    }

    // ---------------- RETURN BOOK ----------------
    public void returnBook(Scanner sc) {
        System.out.print("Enter Member ID: ");
        int memberId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Book ID: ");
        int bookId = Integer.parseInt(sc.nextLine());

        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (member == null || book == null) {
            System.out.println("Invalid IDs!");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("This book is not issued!");
            return;
        }

        book.markAsReturned();
        member.returnIssuedBook(bookId);

        System.out.println("Book returned successfully!");

        saveToFile();
    }

    // ---------------- SEARCH BOOKS ----------------
    public void searchBooks(Scanner sc) {
        System.out.println("Search By:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Category");
        System.out.print("Enter choice: ");
        int ch = Integer.parseInt(sc.nextLine());

        System.out.print("Enter keyword: ");
        String key = sc.nextLine().toLowerCase();

        for (Book b : books.values()) {
            if ((ch == 1 && b.getTitle().toLowerCase().contains(key)) ||
                (ch == 2 && b.getAuthor().toLowerCase().contains(key)) ||
                (ch == 3 && b.getCategory().toLowerCase().contains(key))) {
                b.displayBookDetails();
            }
        }
    }

    // ---------------- SORT BOOKS ----------------
    public void sortBooks() {
        List<Book> list = new ArrayList<>(books.values());
        Collections.sort(list);

        System.out.println("Sorted Books (By Title):");
        for (Book b : list) {
            b.displayBookDetails();
        }
    }

    // ---------------- LOAD FROM FILE ----------------
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                if (p.length == 5) {
                    int id = Integer.parseInt(p[0]);
                    Book book = new Book(id, p[1], p[2], p[3], Boolean.parseBoolean(p[4]));
                    books.put(id, book);
                    if (id >= nextBookId) nextBookId = id + 1;
                }
            }
        } catch (Exception e) { }

        try (BufferedReader br = new BufferedReader(new FileReader(MEMBERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                if (p.length >= 3) {
                    int id = Integer.parseInt(p[0]);
                    Member member = new Member(id, p[1], p[2]);

                    if (p.length == 4) {
                        if (!p[3].isEmpty()) {
                            for (String s : p[3].split(",")) {
                                member.addIssuedBook(Integer.parseInt(s));
                            }
                        }
                    }
                    members.put(id, member);
                    if (id >= nextMemberId) nextMemberId = id + 1;
                }
            }
        } catch (Exception e) { }
    }

    // ---------------- SAVE TO FILE ----------------
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book b : books.values()) {
                bw.write(b.getBookId() + "|" + b.getTitle() + "|" + b.getAuthor() + "|" +
                         b.getCategory() + "|" + b.isIssued());
                bw.newLine();
            }
        } catch (Exception e) { }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(MEMBERS_FILE))) {
            for (Member m : members.values()) {
                bw.write(m.getMemberId() + "|" + m.getName() + "|" + m.getEmail() + "|");

                List<Integer> issued = m.getIssuedBooks();
                for (int i = 0; i < issued.size(); i++) {
                    bw.write(String.valueOf(issued.get(i)));
                    if (i < issued.size() - 1) bw.write(",");
                }
                bw.newLine();
            }
        } catch (Exception e) { }
    }
}

package casiignment4;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private Integer memberId;
    private String name;
    private String email;
    private List<Integer> issuedBooks;

    public Member(Integer memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Integer> getIssuedBooks() {
        return issuedBooks;
    }

    public void displayMemberDetails() {
        System.out.println("Member ID    : " + memberId);
        System.out.println("Name         : " + name);
        System.out.println("Email        : " + email);
        System.out.println("Issued Books : " + issuedBooks);
        System.out.println("--------------------------------------");
    }

    public void addIssuedBook(int bookId) {
        issuedBooks.add(bookId);
    }

    public void returnIssuedBook(int bookId) {
        issuedBooks.remove(Integer.valueOf(bookId));
    }
}

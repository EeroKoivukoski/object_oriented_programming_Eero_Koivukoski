package Task2.Library.model;

import java.util.ArrayList;

public class LibraryMember {
    private static int totalMembers=0;
    private final String name;
    private final int memberID;
    private final ArrayList<Book> borrowedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.memberID = totalMembers++ + 1;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getMemberID() { return memberID; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
}

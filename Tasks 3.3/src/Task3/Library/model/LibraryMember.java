package Task3.Library.model;

import java.util.ArrayList;

public class LibraryMember {
    private static int totalMembers=0;
    private final String name;
    private final int memberID;
    private final ArrayList<Book> borrowedBooks;
    private final ArrayList<Book> reservedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.memberID = totalMembers++ + 1;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getMemberID() { return memberID; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
    public ArrayList<Book> getReservedBooks() { return reservedBooks; }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
    public void reserveBook(Book book) { reservedBooks.add(book); }
    public void removeResevation(Book book) { reservedBooks.remove(book); }
}

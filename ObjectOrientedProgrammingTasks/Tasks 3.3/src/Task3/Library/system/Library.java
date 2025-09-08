package Task3.Library.system;

import Task3.Library.model.Book;
import Task3.Library.model.LibraryMember;
import java.util.ArrayList;

public class Library {
    //creates lists for books and users
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<LibraryMember> members = new ArrayList<>();

    //Add new books into the collection
    public void addBooks(Book book) {
        this.books.add(book);
        System.out.println("Book titled " + book.getTitle() + " added!");
    }

    //Add new users into the system
    public void addLibraryUser(LibraryMember libraryMember) {
        members.add(libraryMember);
        System.out.println(libraryMember.getName()+" added as a member!");
    }

    //method to borrow books (now goes straight to user!)
    public void borrowBook(LibraryMember member, Book book) {
        for (Book possiblebooks : this.books) {
            if (book==possiblebooks) {
                member.borrowBook(book);
                books.remove(book);
                System.out.println("Book titled " + book.getTitle() + " Borrowed!");
                return;
            }
        }
        System.out.println("Book does not exist or is already borrowed!");
    }

    //a method to return books to the collection from users
    public void returnBook(LibraryMember member, Book book) {
        for (Book possiblebooks : member.getBorrowedBooks()) {
            if (book==possiblebooks) {
                books.add(book);
                member.returnBook(book);
                System.out.println("Book titled " + book.getTitle() + " Returned!");
                return;
            }
        }
        System.out.println("Book does not exist or is already borrowed!");
    }

    //A method to reserve a book
    public void reserveBook(LibraryMember member, Book book) {
        if (!book.getReservedStatus()) {
            book.changeReservedStatus();
            member.reserveBook(book);
            System.out.println("Book titled " + book.getTitle() + " Reserved!");
        }
    }

    //A method to cancel a reservation
    public void removeReservation(LibraryMember member, Book book) {
        if (book.getReservedStatus() && member.getReservedBooks().contains(book)) {
            book.changeReservedStatus();
            member.removeResevation(book);
            System.out.println("Book titled " + book.getTitle() + " had its reservation Removed!");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Books reserved for " + member.getName() + "...");
        int counter = 1;
        boolean check = false;
        for (Book book : member.getReservedBooks()) {
            System.out.println(counter++ + ": " +book.getTitle());
            check = true;
        }
        if (!check) {
            System.out.println("No reservations for " + member.getName() + "!");
        }
    }
}

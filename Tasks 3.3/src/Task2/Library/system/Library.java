package Task2.Library.system;

import Task2.Library.model.Book;
import Task2.Library.model.LibraryMember;
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
        System.out.println("You don't have the book currently or the book does not exist!");
    }
}

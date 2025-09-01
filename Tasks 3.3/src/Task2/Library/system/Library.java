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
    }

    //Add new users into the system
    public void addLibraryUser(LibraryMember libraryMember) {
        members.add(libraryMember);
    }

    //method to borrow books (now goes straight to user!)
    public void borrowBook(LibraryMember member, Book book) {
        for (Book possiblebooks : books) {
            if (book==possiblebooks) {
                member.borrowBook(book);
                books.remove(book);
            }
        }
    }

    //a method to return books to the collection from users
    public void returnBook(LibraryMember member, Book book) {
        for (Book possiblebooks : books) {
            if (book==possiblebooks) {
                books.add(book);
                member.returnBook(book);
            }
        }
    }
}

package Task2.Library;

import Task2.Library.model.Book;
import Task2.Library.model.LibraryMember;
import Task2.Library.system.Library;

public class Main {
    public static void main(String[] args) {
        //Creating instances of Library, Book and LibraryMember
        Library library = new Library();
        LibraryMember john = new LibraryMember("John");
        Book falseGods = new Book("False Gods","Graham McNeill",9781849707466L);

        //Adding users and books into the library
        library.addLibraryUser(john);
        library.addBooks(falseGods);

        //Performing borrowing and returning operations
        library.borrowBook(john, falseGods);
        library.returnBook(john, falseGods);

    }
}

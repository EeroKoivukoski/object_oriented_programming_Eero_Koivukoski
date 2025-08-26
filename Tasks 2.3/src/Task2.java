import java.util.ArrayList;

class Book2 {
    private final String title;
    private final String author;
    private final String publicationYear;

    //Constructor for book
    Book2(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //Methods to get variables
    String getTitle() { return title; }
    String getAuthor() { return author; }
    String getPublicationYear() { return publicationYear; }
}

class Library2 {
    private final ArrayList<Book2> books = new ArrayList<>();
    private final ArrayList<Book2> borrowedBooks = new ArrayList<>();

    void addBooks(Book2 book) {
        books.add(book);
    }

    void displayBooks() {
        int count=1;
        boolean check=false;
        System.out.println("Books in the library:");
        for (Book2 book : books) {
            System.out.println(count++ + ". Title:" + '"' + book.getTitle() + '"' + ", Author:" + '"' + book.getAuthor() + '"' + " Publication Year:" + '"' + book.getPublicationYear() + '"');
            check=true;
        }
        if (!check) {
            System.out.println("There are no books in the library!");
        }
        System.out.println();
    }

    void findBooksByAuthor(String author) {
        int count=1;
        boolean check=false;
        System.out.println("Books by the author " + '"' + author + '"' + " :");
        for (Book2 book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(count++ + ". Title:" + '"' + book.getTitle() + '"' + ", Author:" + '"' + book.getAuthor() + '"' + " Publication Year:" + '"' + book.getPublicationYear() + '"');
                check=true;
            }
        }
        if (!check) {
            System.out.println("There are no books by the author "+'"'+author+'"'+" in the library!");
        }
        System.out.println();
    }

    Book2 borrowBook(String title) {
        Book2 wantedBook;
        for (Book2 book : books) {
            if (book.getTitle().equals(title)) {
                wantedBook = book;
                books.remove(book);
                borrowedBooks.add(wantedBook);
                return wantedBook;
            }
        }
        return null;
    }
    void returnBook(Book2 book) {
        if  (borrowedBooks.contains(book)) {
            books.add(book);
            borrowedBooks.remove(book);
        }
        else  {
            System.out.println("Book is not from the library!");
        }

    }
}

class LibraryMain2 {
    public static void main(String[] args) {
        Library2 library2 = new Library2();
        Book2 borrowedbook;
        library2.displayBooks();
        library2.addBooks(new Book2("Horus Rising", "Dan Abnett", "2006"));
        library2.addBooks(new Book2("False Gods","Graham Mcneill","2006"));
        library2.addBooks(new Book2("Galaxy in Flames","Ben courtner", "2006"));
        library2.addBooks(new Book2("The Flight of the Einstein","James Swallow", "2007"));
        library2.addBooks(new Book2("Fulgrim","Graham Mcneill","2007"));
        library2.displayBooks();
        library2.findBooksByAuthor("Graham Mcneill");
        library2.findBooksByAuthor("God Emperor of Mankind");
        borrowedbook=library2.borrowBook("Horus Rising");
        library2.findBooksByAuthor("Dan Abnett");
        library2.returnBook(borrowedbook);
        library2.findBooksByAuthor("Dan Abnett");
    }
}

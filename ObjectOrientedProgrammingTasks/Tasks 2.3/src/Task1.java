import java.util.ArrayList;

class Book {
    private final String title;
    private final String author;
    private final String publicationYear;

    //Constructor for book
    Book(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //Methods to get variables
    String getTitle() { return title; }
    String getAuthor() { return author; }
    String getPublicationYear() { return publicationYear; }
}

class Library {
    private final ArrayList<Book2> books = new ArrayList<>();

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
}

class LibraryMain {
    public static void main(String[] args) {
        Library2 library = new Library2();
        library.displayBooks();
        library.addBooks(new Book2("Horus Rising", "Dan Abnett", "2006"));
        library.addBooks(new Book2("False Gods","Graham Mcneill","2006"));
        library.addBooks(new Book2("Galaxy in Flames","Ben courtner", "2006"));
        library.addBooks(new Book2("The Flight of the Einstein","James Swallow", "2007"));
        library.addBooks(new Book2("Fulgrim","Graham Mcneill","2007"));
        library.displayBooks();
        library.findBooksByAuthor("Graham Mcneill");
        library.findBooksByAuthor("God Emperor of Mankind");
    }
}

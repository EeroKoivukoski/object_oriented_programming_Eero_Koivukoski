import java.util.ArrayList;

class Book3 {
    private final String title;
    private final String author;
    private final String publicationYear;

    //Constructor for book
    Book3(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //Methods to get variables
    String getTitle() { return title; }
    String getAuthor() { return author; }
    String getPublicationYear() { return publicationYear; }
}

class Library3 {
    private final ArrayList<Book5> books = new ArrayList<>();
    private final ArrayList<Book5> borrowedBooks = new ArrayList<>();

    void addBooks(Book5 book) {
        books.add(book);
    }

    void displayBooks() {
        int count=1;
        boolean check=false;
        System.out.println("Books in the library:");
        for (Book5 book : books) {
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
        for (Book5 book : books) {
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

    Book5 borrowBook(String title) {
        Book5 wantedBook;
        for (Book5 book : books) {
            if (book.getTitle().equals(title)) {
                wantedBook = book;
                books.remove(book);
                borrowedBooks.add(wantedBook);
                return wantedBook;
            }
        }
        return null;
    }
    void returnBook(Book5 book) {
        if  (borrowedBooks.contains(book)) {
            books.add(book);
            borrowedBooks.remove(book);
        }
        else  {
            System.out.println("Book is not from the library!");
        }

    }

    Boolean isBookAvailable(String title) {
        for (Book5 book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        for  (Book5 book : borrowedBooks) {
            if (book.getTitle().equals(title)) {
                return false;
            }
        }
        return false;
    }
}

class LibraryMain3 {
    public static void main(String[] args) {
        Library5 library3 = new Library5();
        Book5 borrowedbook;
        library3.displayBooks();
        library3.addBooks(new Book5("Horus Rising", "Dan Abnett", "2006"));
        library3.addBooks(new Book5("False Gods","Graham Mcneill","2006"));
        library3.addBooks(new Book5("Galaxy in Flames","Ben courtner", "2006"));
        library3.addBooks(new Book5("The Flight of the Einstein","James Swallow", "2007"));
        library3.addBooks(new Book5("Fulgrim","Graham Mcneill","2007"));
        library3.displayBooks();
        library3.findBooksByAuthor("Graham Mcneill");
        library3.findBooksByAuthor("God Emperor of Mankind");
        System.out.println("Is book available: "+library3.isBookAvailable("Horus Rising"));
        System.out.println();
        borrowedbook=library3.borrowBook("Horus Rising");
        library3.findBooksByAuthor("Dan Abnett");
        library3.returnBook(borrowedbook);
        library3.findBooksByAuthor("Dan Abnett");
    }
}

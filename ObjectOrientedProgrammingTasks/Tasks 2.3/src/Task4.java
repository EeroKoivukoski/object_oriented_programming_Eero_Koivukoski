import java.util.ArrayList;

class Book4 {
    private final String title;
    private final String author;
    private final String publicationYear;
    private final ArrayList<String> reviews = new ArrayList<>();
    private final ArrayList<Double> ratings = new ArrayList<>();

    //Constructor for book
    Book4(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //Methods to get variables

    String getTitle() { return title; }
    String getAuthor() { return author; }
    String getPublicationYear() { return publicationYear; }
    void addReview(String review) { reviews.add(review); }
    void addRating(double rating) { ratings.add(rating); }
    double getAverageRating() {
        double total = 0;
        for (double rating : ratings){
            total+=rating;
        }
        return total / ratings.size();
    }
    int getAmountOfReviews() { return reviews.size(); }
}

class Library4 {
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
    double getBookRating(String title) {
        for (Book5 book : books) {
            if (book.getTitle().equals(title)) {
                return book.getAverageRating();
            }
        }
        return 0;
    }
    int getAmountOfBookReviews(String title) {
        for (Book5 book : books) {
            if (book.getTitle().equals(title)) {
                return book.getAmountOfReviews();
            }
        }
        return 0;
    }

    }

class LibraryMain4 {
    public static void main(String[] args) {
        Library4 library4 = new Library4();
        Book5 borrowedbook;

        library4.displayBooks();

        library4.addBooks(new Book5("Horus Rising", "Dan Abnett", "2006"));
        library4.addBooks(new Book5("False Gods","Graham Mcneill","2006"));
        library4.addBooks(new Book5("Galaxy in Flames","Ben courtner", "2006"));
        library4.addBooks(new Book5("The Flight of the Einstein","James Swallow", "2007"));
        library4.addBooks(new Book5("Fulgrim","Graham Mcneill","2007"));

        library4.displayBooks();

        library4.findBooksByAuthor("Graham Mcneill");
        library4.findBooksByAuthor("God Emperor of Mankind");

        System.out.println("Is book available: "+library4.isBookAvailable("Horus Rising"));
        System.out.println();

        borrowedbook=library4.borrowBook("Horus Rising");
        library4.findBooksByAuthor("Dan Abnett");
        borrowedbook.addReview("This book is a great introduction to the Horus Heresy series of books!");
        borrowedbook.addRating(5.0);
        borrowedbook.addRating(1.0);
        borrowedbook.addRating(5.0);
        borrowedbook.addRating(5.0);
        library4.returnBook(borrowedbook);

        borrowedbook=library4.borrowBook("False Gods");
        borrowedbook.addReview("This book sucks!");
        borrowedbook.addReview("This book is great!");
        borrowedbook.addRating(5.0);
        borrowedbook.addRating(1.0);
        borrowedbook.addRating(5.0);
        library4.returnBook(borrowedbook);

        library4.findBooksByAuthor("Dan Abnett");
        library4.displayBooks();

        System.out.println("Amount of reviews"+library4.getAmountOfBookReviews("Horus Rising"));
        System.out.println();

        System.out.println("Average rating of the book"+library4.getBookRating("Horus Rising"));
        System.out.println();

    }
}

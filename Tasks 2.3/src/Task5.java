import java.util.ArrayList;

class Book5 {
    private final String title;
    private final String author;
    private final String publicationYear;
    private final ArrayList<String> reviews = new ArrayList<>();
    private final ArrayList<Double> ratings = new ArrayList<>();

    //Constructor for book
    Book5(String title, String author, String publicationYear) {
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

class Library5 {
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
    String getMostReviewedBook() {
        Book5 wantedBook = books.getFirst();
        for (Book5 book : books) {
            if (book.getAmountOfReviews() > wantedBook.getAmountOfReviews()){
                wantedBook = book;
            }
        }
        return wantedBook.getTitle();
    }

    double getAverageBookRating() {
        int count=0;
        double totalRating=0;
        for  (Book5 book : books) {
            if (book.getAverageRating() > 0) {
                count++;
                totalRating += book.getAverageRating();
            }
        }
        return totalRating/count;
    }
}

class LibraryMain5 {
    public static void main(String[] args) {
        Library5 library5 = new Library5();
        Book5 borrowedbook;

        library5.displayBooks();

        library5.addBooks(new Book5("Horus Rising", "Dan Abnett", "2006"));
        library5.addBooks(new Book5("False Gods","Graham Mcneill","2006"));
        library5.addBooks(new Book5("Galaxy in Flames","Ben courtner", "2006"));
        library5.addBooks(new Book5("The Flight of the Einstein","James Swallow", "2007"));
        library5.addBooks(new Book5("Fulgrim","Graham Mcneill","2007"));

        library5.displayBooks();

        library5.findBooksByAuthor("Graham Mcneill");
        library5.findBooksByAuthor("God Emperor of Mankind");

        System.out.println("Is book available: "+library5.isBookAvailable("Horus Rising"));
        System.out.println();

        borrowedbook=library5.borrowBook("Horus Rising");
        library5.findBooksByAuthor("Dan Abnett");
        borrowedbook.addReview("This book is a great introduction to the Horus Heresy series of books!");
        borrowedbook.addRating(5.0);
        borrowedbook.addRating(1.0);
        borrowedbook.addRating(5.0);
        borrowedbook.addRating(5.0);
        library5.returnBook(borrowedbook);

        borrowedbook=library5.borrowBook("False Gods");
        borrowedbook.addReview("This book sucks!");
        borrowedbook.addReview("This book is great!");
        borrowedbook.addRating(5.0);
        borrowedbook.addRating(1.0);
        borrowedbook.addRating(5.0);
        library5.returnBook(borrowedbook);

        library5.findBooksByAuthor("Dan Abnett");
        library5.displayBooks();

        System.out.println("Amount of reviews"+library5.getAmountOfBookReviews("Horus Rising"));
        System.out.println();

        System.out.println("Average rating of the book"+library5.getBookRating("Horus Rising"));
        System.out.println();

        System.out.println("Most reviewed book in the library is "+library5.getMostReviewedBook());
        System.out.println();

        System.out.println("Average book rating "+library5.getAverageBookRating());
        System.out.println();

    }
}

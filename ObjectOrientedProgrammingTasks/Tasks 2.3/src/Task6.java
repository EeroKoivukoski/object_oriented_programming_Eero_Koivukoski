//Imports
import java.util.ArrayList;

//Class to create user objects that have the variables age,name and borrowedbooks
class User {
    //creates variables here
	String name;
	int age;
    ArrayList<Book6> borrowedBooks =  new ArrayList<>();

    //Constructor for user
	User(String name,int age) {
        this.name=name;
        this.age=age;
    }

    //Borrow book method, just adds the borrowed book here
    void borrowBook(Book6 book) {
        borrowedBooks.add(book);
    }

    //Return book method retreives books from borrowedBooks list
    Book6 returnBook(String title) {
        for (Book6 book: borrowedBooks) {
            if  (book.getTitle().equals(title)) {
                borrowedBooks.remove(book);
                return book;
            }
        }
        return null;
    }
}

//Class to create book objects
class Book6 {
    private final String title;
    private final String author;
    private final String publicationYear;
    private final ArrayList<String> reviews = new ArrayList<>();
    private final ArrayList<Double> ratings = new ArrayList<>();

    //Constructor for book
    Book6(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //Methods to get variables out of books
    String getTitle() { return title; }
    String getAuthor() { return author; }
    String getPublicationYear() { return publicationYear; }

    //Methods to Add reviews to books
    void addReview(String review) { reviews.add(review); }
    void addRating(double rating) { ratings.add(rating); }

    //method to get the current average rating out
    double getAverageRating() {
        double total = 0;
        for (double rating : ratings){
            total+=rating;
        }
        return total / ratings.size();
    }

    //retreives the amount of reviews the book has
    int getAmountOfReviews() { return reviews.size(); }
}

//Class to create Library object
class Library6 {
    //creates lists for books and users
    private final ArrayList<Book6> books = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();

    //Add new books into the collection
    void addBooks(Book6 book) {
        books.add(book);
    }

    //display all books that are at the library
    void displayBooks() {
        //count to make the list look nicer
        int count=1;
        //check to make sure if there are books in the collection
        boolean check=false;
        System.out.println("Books in the library:");
        for (Book6 book : books) {
            System.out.println(count++ + ". Title:" + '"' + book.getTitle() + '"' + ", Author:" + '"' + book.getAuthor() + '"' + " Publication Year:" + '"' + book.getPublicationYear() + '"');
            check=true;
        }
        if (!check) {
            System.out.println("There are no books in the library!");
        }
        System.out.println();
    }

    //Method to list all books made by a certain author
    void findBooksByAuthor(String author) {
        int count=1;
        boolean check=false;
        System.out.println("Books by the author " + '"' + author + '"' + " :");
        for (Book6 book : books) {
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

    //method to borrow books (now goes straight to user!)
    void borrowBook(String title,String username) {
        Book6 wantedBook = null;
        boolean check=false;
        for (Book6 book : books) {
            if (book.getTitle().equals(title)) {
                for (User user : users) {
                    if (user.name.equals(username)) {
                        user.borrowedBooks.add(book);
                        check=true;
                        wantedBook=book;
                    }
                }
            }
        }
        if(check) {
            books.remove(wantedBook);
        }
    }
   //a method to return books to the collection from users
    void returnBook(String bookname,String username) {
        for (User user: users) {
            if (user.name.equals(username)) {
                for (Book6 book : user.borrowedBooks) {
                    if (book.getTitle().equals(bookname)) {
                        books.add(book);
                        user.borrowedBooks.remove(book);
                        break;
                    }
                }
            }
        }
    }

    //method to check if abook is currently in the collection
    Boolean isBookAvailable(String title) {
        for (Book6 book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    //Method to get a single books average rating
    double getBookRating(String title) {
        for (Book6 book : books) {
            if (book.getTitle().equals(title)) {
                return book.getAverageRating();
            }
        }
        return 0;
    }

    //gives a singular books amount of reviews
    int getAmountOfBookReviews(String title) {
        for (Book6 book : books) {
            if (book.getTitle().equals(title)) {
                return book.getAmountOfReviews();
            }
        }
        return 0;
    }

    //gives the most reviewed book from the collection
    String getMostReviewedBook() {
        Book6 wantedBook = books.getFirst();
        for (Book6 book : books) {
            if (book.getAmountOfReviews() > wantedBook.getAmountOfReviews()){
                wantedBook = book;
            }
        }
        return wantedBook.getTitle()+'"'+" by: "+'"'+ wantedBook.getAuthor()+'"';
    }

    //gives average book raiting of the whole library
    double getAverageBookRating() {
        int count=0;
        double totalRating=0;
        for  (Book6 book : books) {
            if (book.getAverageRating() > 0) {
                count++;
                totalRating += book.getAverageRating();
            }
        }
        return totalRating/count;
    }

    //add a new user to the library
    void addLibraryUser(String name,int age){
        users.add(new User(name,age));
    }

    //add a review
    void addReview(String username,String bookname,String review){
        for (User user : users) {
            if (user.name.equals(username)) {
                for (Book6 book : user.borrowedBooks) {
                    if (book.getTitle().equals(bookname)) {
                        book.addReview(review);
                    }
                }
            }
        }
    }
    //add a rating
    void addRating(String username,String bookname,int rating){
        for (User user : users) {
            if (user.name.equals(username)) {
                for (Book6 book : user.borrowedBooks) {
                    if (book.getTitle().equals(bookname)) {
                        book.addRating(rating);
                    }
                }
            }
        }
    }
}

//class to test our library,book,user classes
class LibraryMain6 {
    public static void main(String[] args) {
        //create a library object
        Library6 library6 = new Library6();
        library6.addLibraryUser("eero",21);
        library6.addLibraryUser("tommi",28);

        //show of no books
        library6.displayBooks();

        //adding the first five books of the horus heresy series
        library6.addBooks(new Book6("Horus Rising", "Dan Abnett", "2006"));
        library6.addBooks(new Book6("False Gods","Graham Mcneill","2006"));
        library6.addBooks(new Book6("Galaxy in Flames","Ben courtner", "2006"));
        library6.addBooks(new Book6("The Flight of the Einstein","James Swallow", "2007"));
        library6.addBooks(new Book6("Fulgrim","Graham Mcneill","2007"));

        //showing that the books appear in the collection
        library6.displayBooks();

        //showing that finding books by author works
        library6.findBooksByAuthor("Graham Mcneill");

        //also it doesn't crash if the author doesnt exist
        library6.findBooksByAuthor("God Emperor of Mankind");

        // checks the book availability
        System.out.println("Is book available: "+library6.isBookAvailable("Horus Rising"));
        System.out.println();

        //test of the borrowing system
        library6.borrowBook("Horus Rising","eero");

        //shows that the book isn't in the collection anymore
        library6.findBooksByAuthor("Dan Abnett");

        //adding a rating to the book
        library6.addRating("eero","Horus Rising",5);

        //adding a review to the book
        library6.addReview("eero","Horus Rising","The book is a great introduction to 40.000 and the horus heresy series!");

        //returning the book
        library6.returnBook("Horus Rising","eero");

        //Showing that the book is back
        library6.findBooksByAuthor("Dan Abnett");

        //Adding more reviews and ratings
        library6.borrowBook("False Gods","tommi");
        library6.addReview("tommi","False Gods","This book sucks.");
        library6.addReview("tommi","False Gods","Scratch that last review.");
        library6.addRating("tommi","False Gods",4);
        library6.returnBook("False Gods","tommi");

        //testing the show reviews for single book in collection
        System.out.println("Amount of reviews "+library6.getAmountOfBookReviews("Horus Rising"));
        System.out.println();

        //testing the show average ratings for a single book in collection
        System.out.println("Average rating of the book"+library6.getBookRating("Horus Rising"));
        System.out.println();

        //most reviewed book
        System.out.println("Most reviewed book in the library is "+'"'+library6.getMostReviewedBook());
        System.out.println();

        //average for the whole library
        System.out.println("Average book ratings for the library "+library6.getAverageBookRating());
        System.out.println();
    }
}

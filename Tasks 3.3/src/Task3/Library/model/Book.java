package Task3.Library.model;

public class Book {
    private final String title;
    private final String author;
    private final long isbn;
    private boolean reserved;

    public Book(String title, String author, long isbn) {
        this.title = title;
        this.author = author;
        this.isbn =isbn;
        this.reserved = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public long getIsbn() { return isbn; }
    public boolean getReserved() { return reserved; }
    public void changeReservedStatus() { this.reserved = !this.reserved; }

}

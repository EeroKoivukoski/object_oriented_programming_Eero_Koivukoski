package Task2.Library.model;

public class Book {
    private final String title;
    private final String author;
    private final long isbn;
    public Book(String title, String author, long isbn) {
        this.title = title;
        this.author = author;
        this.isbn =isbn;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public long getIsbn() { return isbn; }
}

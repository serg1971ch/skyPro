public class Book {
    private String  title;
    private Author author;
    private int date;

    public Book(String title, Author author, int date)  {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}

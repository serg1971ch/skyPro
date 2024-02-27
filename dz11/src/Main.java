public class Main {
    public static void main(String[] args) {
        Author author = new Author("Айзек", "Азимов");
        Author author1 = new Author("Джон", "Толкиен");
        Book book =  new Book("Академия", author, 1942);
        Book book1 = new Book("Властелин колец. Братство кольца", author1, 1937);
        book.setDate(1953);
    }
}
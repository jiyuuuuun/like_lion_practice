package happyjava.src.day11;

public class Book {
    String title;

    String author;

    int year;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public Book(String title,String author,int year) {
        this.title=title;
        this.author=author;
        this.year=year;
    }
}

import java.util.HashSet;

public class HashSetTest2 {
    public static void main(String[] args) {
        //make 5 books and add them in the HashSet
        //....

        HashSet<Book> bookShelf = new HashSet<Book>();
        //add the books in the bookShelf

        //and then print them via Iterator<Book> ....

    }
}
class Book
{
    int bookNumber;
    String bookTitle;
    String author;
    int numberOfPages;
    int edition;
    double cost;
    int yearOfPublication;

    public Book(int bookNumber, String bookTitle, String author, int numberOfPages, int edition, double cost, int yearOfPublication) {
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.edition = edition;
        this.cost = cost;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", edition=" + edition +
                ", cost=" + cost +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}

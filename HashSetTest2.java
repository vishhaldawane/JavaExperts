import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/*interface Washing {
    void wash();
}
class Husband implements Washing, Cleaning, ..........{
    public void wash() { }
}*/
public class HashSetTest2 {
    //hashcode wise all the books are different, but content wise they can be duplicate
    public static void main(String[] args) {
       Book b1 = new Book(101,"Java8","James Gosling",1200,4,800,1998); //new keyword means a new data structure (7 fields of Book to be created)
       System.out.println("hash code of b1 "+b1.hashCode());

       Book b2 = b1; //although reference is different, will the hashcode be same or diff?
       System.out.println("hash code of b2 "+b2.hashCode());

       Book b3 = new Book(101,"Java8","James Gosling",1200,6,800,1998);
       System.out.println("hash code of b3 "+b3.hashCode());

        Book b4 = new Book(101,"Java8","James Gosling",1200,8,800,1998);
        System.out.println("hash code of b4 "+b4.hashCode());

        Book b5 = new Book(101,"Java8","James Gosling",1200,9,800,1998);
        System.out.println("hash code of b5 "+b5.hashCode());

        HashSet<Book> bookShelf = new HashSet<Book>();
       System.out.println("adding a book b1"); bookShelf.add(b1);
       System.out.println("adding a book b1"); bookShelf.add(b1); //add wont work
       System.out.println("adding a book b1"); bookShelf.add(b1);//add wont work
       System.out.println("adding a book b1"); bookShelf.add(b1);//add wont work
       System.out.println("adding a book b2"); bookShelf.add(b2);//add wont work
       System.out.println("adding a book b2"); bookShelf.add(b2);
       System.out.println("adding a book b3"); bookShelf.add(b3);
        System.out.println("adding a book b4"); bookShelf.add(b4);
        System.out.println("adding a book b5"); bookShelf.add(b5);

        Iterator<Book> myIterator = bookShelf.iterator(); // ITERATOR,  STRAW
        while (myIterator.hasNext()) {
            Object obj  = myIterator.next();
            if(obj instanceof Book) {
                Book value = (Book) obj; //convert obj into an int - unsafe if it doesnt match, ClassCastException
                System.out.println("Book value : " + value);
            }
        }

    }
}
// equals() and hashCode() - inherited methods in every class

class Book // extends Object ... Object class has 11 methods in it
{
    int bookNumber;
    String bookTitle;
    String author;
    int numberOfPages;
    int edition;
    double cost;
    int yearOfPublication;

    public Book() {
        System.out.println("Book() no arg constructor");
    }
    public Book(int bookNumber) {
        System.out.println("Book(int) no arg constructor");
        this.bookNumber = bookNumber;
    }
    public Book(int bookNumber, String bookTitle, String author, int numberOfPages, int edition, double cost, int yearOfPublication) {
        System.out.println("Book(7 arguments)  constructor");
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
//b1.equals(b3)


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookNumber == book.bookNumber && edition == book.edition && bookTitle.equals(book.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookNumber, bookTitle, edition);
    }
}

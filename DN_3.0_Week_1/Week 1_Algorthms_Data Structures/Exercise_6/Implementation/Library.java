import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search to find books by title
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            if (midBook.getTitle().equalsIgnoreCase(title)) {
                return midBook;
            } else if (midBook.getTitle().compareToIgnoreCase(title) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Method to display all books
    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

import java.util.Arrays;

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int compareTo(Book b) {
        return this.title.compareToIgnoreCase(b.title);
    }

    @Override
    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibraryManagement {
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title))
                return b;
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Java Programming", "James"),
            new Book(102, "Data Structures", "Mark"),
            new Book(103, "Algorithms", "Robert")
        };

        Arrays.sort(books); // Sort for binary search

        System.out.println("Linear Search: " + linearSearch(books, "Java Programming"));
        System.out.println("Binary Search: " + binarySearch(books, "Data Structures"));
    }
}

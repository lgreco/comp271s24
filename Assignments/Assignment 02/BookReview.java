import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

public class BookReview {

    /**
     * Scans a book and places its unique words into a dynamic array
     * @param url Link to an online book (text only)
     * @return dynamic array with the contents of the book. If the
     * connection to the book cannot be established, the method will
     * return a null.
     */
    public static DynamicArray scanBook(String link) {
        DynamicArray words = null;
        Scanner bookScanner = connectToBook(link);
        // connectToBook will return a null if we cannot connect.
        if (bookScanner != null) {
            // Connection successful, let's initialize the dynamic array
            words = new DynamicArray();
            while (bookScanner.hasNext()) {
                words.addUnique(bookScanner.next());
            }
        }
        return words;
    } // method scanBook

    /**
     * Establishes a Scanner on a weblink. If the connection can not be made,
     * the method returns a null. That's how we can tell something went wrong
     * and decide what to do next.
     * @param link String with link to website with text to scan
     * @return Scanner connected to the website or null if connection cannot be made
     */
    public static Scanner connectToBook(String link) {
        Scanner bookScanner;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            bookScanner = new Scanner(stream);
        } catch (Exception e) {
            bookScanner = null;
        }
        return bookScanner;
    } // method connecttoBook

    public static void main(String[] args) {
        // https://gutenberg.org/cache/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";
    } // method main
} // class BookReview
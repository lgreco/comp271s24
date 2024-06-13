import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

/*
NO IMPORT STATEMENTS. NO CALLS TO SYSTEM.anything, except for 
System.out.println or print or printf as needed.
 */ 
public class BookReview_Solution {

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

    /**
     * Returns the count of unique words in a text document accessible as a web lik
     * 
     * @param bookLink String web link to text document to scan
     * @return int with count of unique words found
     */
    public static int countUniqueWords(String bookLink) {
        DynamicArray uniqueWords = new DynamicArray();
        Scanner book = connectToBook(bookLink);
        while (book.hasNext()) {
            boolean added = uniqueWords.addUnique(book.next());
        }
        return uniqueWords.getPosition();
    } // method countUniqueWords


    public static void main(String[] args) {
        // https://gutenberg.org/cache/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";
        
        int uniqueWords = countUniqueWords(book);
        System.out.printf("\n\nFound %,d unique words.\n", uniqueWords);
    } // method main
} // class BookReview

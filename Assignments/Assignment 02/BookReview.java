import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
NO IMPORT STATEMENTS. NO CALLS TO SYSTEM.anything, except for 
System.out.println or print or printf as needed.
 */ 
public class BookReview {

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


    // Reads text from the scanner and returns a string which is the text from the book.
    public static String readText (Scanner scanner) { //connected to the book
        StringBuilder bookText = new StringBuilder();
        while (scanner.hasNextLine()) {
            bookText.append(scanner.nextLine()).append(" ");

        }
        return bookText.toString();
    }


    //counts words that are different or unique 
    public static int countWords(String text) {
        List<String> uniqueWords = new ArrayList<>();
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (!word.isEmpty() && !uniqueWords.contains(word.toLowerCase())) {
                uniqueWords.add(word.toLowerCase());
            }
        }
        return uniqueWords.size();
    }


    public static void main(String[] args) {
        // https://gutenberg.org/cache/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";


        //Connects to the book, if null  prints failed connection. 
        Scanner bookScan = connectToBook(book);
        if (bookScan == null) {
            System.out.println("Book fail to connect");
            return;
        }

        //Reads the text 
        String bookText = readText(bookScan);

        //Counts the unique words 
        int uniqueWordCount = countWords(bookText);

        //shows the output
        System.out.println("Number of unique words in the book is: " + uniqueWordCount);

    } // method main
} // class BookReview

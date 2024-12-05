import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

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

    public static void main(String[] args) {
        // https://gutenberg.org/cach   jfjdfjfjfie/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg https://www.gutenberg.org/files/98/98-h/98-h.htm
        String book = "https://learning.oreilly.com/library/view/a-common-sense-guide/9781680508048/f_0013.xhtml";
        Scanner bookScanner = connectToBook(book);

        if(bookScanner != null){
            print(CountUniqueWords);
        }
    } // method main
    public static void (CountUniqueWords){
        boolean[] array = new boolean[words.length];
        int j, i = 0;
        int count = 0;
        for (i = 0; i < words.length; i++) {
                count++;
                for (j = i + 1; j < words.length; j++) {
                    if (words[j].compareTo(words[i]) == 0) {
                        array[j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int count = CountUniqueWords(str);
        System.out.println(count);
    }

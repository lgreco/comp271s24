import java.io.File;
import java.util.Scanner;

/**
 * A more sophisticated application to assign seats to passengers in a small
 * airplane with a specific number of rows and seats per row. The program
 * reads the passenger manifest from a file. For every passenger, it assigns
 * a seat, beginning from the first row.
 */
class Sophisticated {

	// Constant for leftmost seat's ASCII value
	static final int LEFTMOST_SEAT_ASCII = (int) 'A';

	// Constant for number of seats per row
	static final int SEATS_PER_ROW = 4;

	// Constant for number of rows in the airplane
	static final int ROWS = 10;

	// Constant with passenger list file name
	static final String PASSENGER_LIST = "passengers.txt";

	// Constant with data folder
	static final String DATA_FOLDER = "data/";

	/**
	 * Instantiate a File connection to the file with the passenger information.
	 * By default, data files in Codespaces are expected to be in the root
	 * folder. If the file cannot be found, the method returns null which can
	 * then be handled by other methods to determine how to end the program.
	 * The use of try/catch here is preferred to having the method throw an
	 * exception and crashing the program.
	 * 
	 * @param filename String with name of file to read
	 * @return File object connected to the file to read, or null if
	 *         file cannot be found
	 */
	public static File connectToFile(String filename) {
		// The return object
		File file;
		// Filepath to the data file
		String pathToFile = DATA_FOLDER + filename;
		// Instead of throwing an exception in case something goes wrong
		try {
			// If file accessible, assign it to the return object
			file = new File(pathToFile);
		} catch (Exception e) {
			// But if something's wrong, make the return object null,
			// and let another part of the program handle the situation.
			file = null;
		}
		// Done
		return file;
	} // method connectToFile

	/**
	 * Establish a Scanner connection to a file. Instead of throwing an exception,
	 * the method returns a null, if a connection cannot be established.
	 * 
	 * @param filename String with name of file to pass to scanner
	 * @return Scanner for the file or null if connection cannot be established.
	 */
	public static Scanner connectScanner(String filename) {
		// Return object
		Scanner scanner = null;
		File file = connectToFile(filename);
		// If a connection to the file cannot be established, connectToFile
		// will return a null. Here, we attampt to connect a Scanner to file
		// only if it's not null.
		if (file != null) {
			try {
				// If the connection is successful, object scanner has it.
				scanner = new Scanner(file);
			} catch (Exception e) {
				// If something goes wrong ensure we're returning a null.
				scanner = null;
			}
		}
		// Done
		return scanner;
	} // method connectScanner

	/**
	 * Principal method of our application. It takes a passenger list, as an
	 * input file, and assigns seats.
	 * 
	 * @param manifest String with name of passenger list
	 */
	public static void seatPassengers(String manifest) {
		// Attempt to establish a scanner connection to the passenger list
		Scanner passengers = connectScanner(manifest);
		// If something goes wrong, print a message and end the program
		if (passengers == null) {
			System.out.printf("\n\nCannot connect to file %s.\n\n",
					PASSENGER_LIST);
		} else {
			// Connection to file established. Let's initiate a counter
			// because we cannot seat more passenger than the number of
			// seats in the airplane.
			int counter = 0;
			// Print a header
			System.out.printf("\n\nSeating Chart\n");
			// Process every passenger in the passenger list, while keeping an
			// eye out not to board more passengers than the plane can fit.
			while (passengers.hasNext() && counter < ROWS * SEATS_PER_ROW) {
				String passenger = passengers.nextLine();
				/*
				 * Row number is obtained by simple integer division; we add 1 to
				 * offset the 0 quotient for the first four passengers:
				 * 0/SEAT_PER_ROW, 1/SEAT_PER_ROW, 2/SEAT_PER_ROW, 3/SEAT_PER_ROW,
				 * all evaluate to 0 but these are the people who will assigned
				 * seats 1A, 1B, 1C, and 1D
				 */
				int row = 1 + counter / SEATS_PER_ROW;
				// Seat letter is a based on modulo values
				char seatLetter = (char) (LEFTMOST_SEAT_ASCII + counter % SEATS_PER_ROW);
				// Print the seat assignments.
				System.out.printf("\nSeat %2d%s assigned to %s",
						row, seatLetter, passenger);
				// Update teh counter
				counter++;
			}
			// Keep an eye out in case there are still passengers in the manifest and
			// we are out of seats.
			if (passengers.hasNext()) {
				System.out.printf("\n\nWARNING: There are more passengers than seats.\n");
			}
		}
	} // method seatPassengers

	/**
	 * Driver code
	 */
	public static void main(String[] args) {
		seatPassengers(PASSENGER_LIST);
	} // method main
} // class Naive
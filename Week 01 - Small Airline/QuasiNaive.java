/**
 * A less naive program to arrange a list of passengers into the seats of a small
 * airplane with 10 rows of seating. Each row has 4 seats. Rows are labeled
 * from 1 to 10. Seats are labeled A,B,C,D. Passengers are assigned a seat in
 * the order they appear in the passenger list. 
 * 
 * In this naive implementation, the passenger list is an array of Strings.
 */
class QuasiNaive {

	// Constant for leftmost seat's ASCII value
	static final int LEFTMOST_SEAT_ASCII = (int) 'A';

	// Constant for number of seats per row
	static final int SEATS_PER_ROW = 4;

	// Constant for number of rows in the airplane
	static final int ROWS = 10;

	// Passenger list -- ideally this needs to be in a fle for for now 
	// an array will suffice.
	static String[] passengers = {
		"Bilberry Baggins", "Marigold Took", "Brackenburrow Proudfoot",
		"Frothmoss Goodbody", "Pippin Thistletoe", "Tansy Greenhill",
		"Rowan Smallburrow", "Dandelion Sackville", "Bramblefoot Brandybuck",
		"Fredegar Bolger", "Folco Boffin", "Hilda Bracegirdle"};


	public static void main(String[] args) {
		// In this quasi-naive implementation, all the processing is done inside
		// the loop that processes every passenger. We use the loop index as the
		// principal variable for our computations.
		for (int i = 0; i < passengers.length; i++) {
			/* Row number is determined by simple integer division, noting that
			 * 0/4, 1/4, 2/4, and 3/4 all equal to 0; then
			 * 4/4, 5/4, 6/4, and 7/4 all equal to 1; etc.
			 */
			int row = 1 + i/SEATS_PER_ROW;
			// Seat letter is determined by modulo arithmetic
			char seatLetter = (char) (LEFTMOST_SEAT_ASCII + i%SEATS_PER_ROW);
			// Assign current passenger to row and seatLetter
			System.out.printf("\nSeat: %d%s for passenger: %s",
			row, seatLetter, passengers[i]);
			
		}
	} // method main
} // class Naive
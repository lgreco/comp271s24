/**
 * A naive program to arrange a list of passengers into the seats of a small
 * airplane with 10 rows of seating. Each row has 4 seats. Rows are labeled
 * from 1 to 10. Seats are labeled A,B,C,D. Passengers are assigned a seat in
 * the order they appear in the passenger list. 
 * 
 * In this naive implementation, the passenger list is an array of Strings.
 */
class Naive {

	// Passenger list -- ideally this needs to be in a fle for for now 
	// an array will suffice.
	static String[] passengers = {
		"Bilberry Baggins",  "Marigold Took", "Brackenburrow Proudfoot",
		"Frothmoss Goodbody", "Pippin Thistletoe", "Tansy Greenhill",
		"Rowan Smallburrow", "Dandelion Sackville", "Bramblefoot Brandybuck"};


	public static void main(String[] args) {
		// Seat counter; it helps us tell when we have seated four passengers
		// so that we can move to the next row.
		int counter = 0;
		// Seat assignment; this rotates from A to B to C to D, before we move
		// to the next row and start again from A
		char seatLetter = 'A';
		// Current row; this is the row where we are currently seating 
		// passengers. As soon as 4 passengers have been seated, we move
		// to the next row.
		int row = 1;
		// Go through every passenger in the passenger list and assign them 
		// a seat.
		for (int i = 0; i < passengers.length; i++) {
			// Assign current passenger to row and seatLetter
			System.out.printf("\nSeat: %d%s for passenger: %s",
			row, seatLetter, passengers[i]);
			// Update counter
			counter = counter + 1;
			/*
			 * Advance to the next seat. We need to do some juggling here to
			 * with data types. First we convert seatLetter to an integer and
			 * increment it by 1. That, in essence, increases the ASCII value,
			 * for example, the ASCII value of A is 65 and of B is 66, etc.
			 * After we perform the int addition we convert the updated ASCII
			 * value to a character, that gives us the next seat letter.
			 * seatLetter = (char)((int)(seatLetter)+1);
			 */
			seatLetter = (char) ((int) seatLetter+1);
			// Check counter to see if we seated 4 passengers so that we can
			// move to the next row
			if (counter > 3) { 
				// Four passengers seated already; reset counter for next 4 pax
				counter = 0; 
				// Move to the next row
				row = row +1 ; 
				// Start from seat A again
				seatLetter = 'A';
			}
		}
	} // method main
} // class Naive
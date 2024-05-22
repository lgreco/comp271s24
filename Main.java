/*
 * counter = 0
 * seatLetter = 'A'
 * row = 1
 * for every passenger in the manifest
 *   assign row, seatLetter to the passenger
 *   seatLetter = seatLetter + 1 // move to the next seat
 *   counter = counter + 1 // incr. counter of seated passengers
 *   if counter > 3 // 4 passengers seated already
 *     counter = 0 // reset counter for next 4 passengers
 *     seatLetter = 'A'  // reset seating to leftmost seat
 *     row = row + 1 // move to the next row
 */
class Main {

	static String[] passengers = {
		"Bilberry Baggins",
		"Marigold Took",
		"Brackenburrow Proudfoot",
		"Frothmoss Goodbody",
		"Pippin Thistletoe",
		"Tansy Greenhill",
		"Rowan Smallburrow",
		"Dandelion Sackville",
		"Bramblefoot Brandybuck",
		"Petalbloom Cotton",
		"Oakleaf Bracegirdle",
		"Ivybrook Underhill",
		"Thistledown Brownlock",
		"Hazelbush Sandheaver",
		"Fernshadow Tunneler"
	};

	static final char LEFTMOST_SEAT = 'A';

	public static void main(String[] args) {
		int counter = 0;
		char seatLetter = LEFTMOST_SEAT;
		int row = 1;
		// For every passenger in the manifest
		for (int i = 0; i < passengers.length; i++) {
			// Assign current passenger to row and seatLetter
			System.out.printf("\nSeat: %d%s for passenger: %s",
			row, seatLetter, passengers[i]);
			counter = counter + 1; // counter++;
			seatLetter = (char)((int)(seatLetter)+1);
			if (counter > 3) { // if 4 passengers seated already
				counter = 0; // reset counter for next 4 pax
				seatLetter = LEFTMOST_SEAT; // start seating from leftmost
				row = row +1; // move to next row
			}
		}
	}
}
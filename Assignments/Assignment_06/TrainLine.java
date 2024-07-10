public class TrainLine {

    /** Points to first station in the train line */
    private Station head;

    /**
     * Points to the last station and facilitates O(1) performance when adding
     * a new station at the end of the line
     */
    private Station tail;

    /** Current number of stations in this object */
    private int numberOfStations;

    /** Default constructor - redundant but good to show intent */
    public TrainLine() {
        this.head = null;
        this.tail = null;
        this.numberOfStations = 0;
    } // default constructor

    /** Accessor for number of stations present in this trainline */
    public int getNumberOfStations() {
        return this.numberOfStations;
    } // method getNumberOfStations

    /**
     * Add a new station at the end of this trainline. The method creates
     * a new station object, first, with the given name. Then it checks to
     * if this line has a head station yet; if not, the new station becomes
     * the head station. If this line has a head station, the method begins
     * traversing this line from its head station, following the next points
     * untils it finds a station whose next is null. That station, by definition
     * is presently the last station in the line. The new station is added after
     * that last station.
     * 
     * @param name String with name of new station to add
     */
    public void addStation(String name) {
        // Create a new station object with the given name
        Station newStation = new Station(name);
        // Use addStion(Station) method
        this.addStation(newStation);
    } // method addStation

    /**
     * Add a new station at the end of this trainline. The method takes
     * a station object and it checks if this line has a head station yet; 
     * if not, the new station becomes the head station. If this line has a 
     * head station, the method places the new station after the last station 
     * in the line and marks that new station the last station in the line.
     * 
     * @param station Station object to insert at teh end of the line
     */ 
    
     //Unidirectional route from left to right (employing only `Station.next` pointers):

     //Assignment 6
    public void addStation(Station station) {
        // Check if this trainline has a head station yet or not
        if (this.head == null) {
            // There is no head station in this trainline. Make the
            // new station, just created, the head station and also
            // the tail station of the line and we are done.
            this.head = station;
            this.tail = station;
        } else {
            // The trainline has an existing head station. Therefore,
            // it also has a known last station (this.tail).
            this.tail.setNext(station); // add new station after tail station
            station.setPrev(this.tail); // Bidirectional link. The opposite direction 
            this.tail = station; // Designate newly added station as tail station
        }
        // Update station counter
        this.numberOfStations++;
    }
    public void leftToRight() {
        if (this.numberOfStations > 1) { //make sure the starting point is the head
            this.head.setPrev(null); // make sure the head station's previous is null
        }
        while (current != null) { //bidirectional route: Simply sets next pointer from head to the new station.
            System.out.print(current.getName()); //select the current station which is the head
            if (current.getNext() != null) {  //next pointer from head to the tail
                System.out.print();
            }
            current = current.getNext(); //select the station after the head to the right
        }
        System.out.println();
    }
    public void rightToleft() { //unidirectional route: Simply sets next pointer from tail to a previous station and reaches head.
        if (this.tail != null)  //check that the tail is not equal to null
        while (current != null) {// check where the current station is and make sure it is not null
            System.out.print(current.getName()); //print out the current station's name
            if (current.getPrev() != null) { //go back a station and print out the previous one
                System.out.print();
            }
            current = current.getPrev();
    }
    } // method addStation

    /**
     * Determines if the linked list contains a loop. A loop forms when
     * the last station (this.tail) points to another station in the
     * train line instead of pointing to null. An empty line (this.head==null)
     * is considered loop-free.
     * 
     * @return true if there is a loop, false otherwise
     */
    public boolean hasLoop() {
        boolean loopFound = false;
        // Perform the check only when the train line is not empty
        if (this.head != null) {
            // Create a fast and a slow cursor.
            Station fast = this.head;
            Station slow = this.head;
            while (!loopFound && fast.hasNext() && fast.getNext().hasNext()) {
                fast = fast.getNext().getNext();
                slow = slow.getNext();
                loopFound = (slow == fast);
            }
        }
        return loopFound;
    } // method hasLoop

    /** THIS METHOD IS A STUB ... REPLACE IT WITH YOUR NICE CODE. */
    public boolean contains(String stationName) {
        return true; // method stub
    }

    /**
     * Inserts a new station after an existing one.
     * 
     * @param existingStationName String with name of existing station that we
     *                            are adding a station after.
     * @param stationToAdd        String with name of new station to add.
     * @return true if insertion is successful, false if there is a problem.
     *         Potential problems inlude the presence of the station we are trying
     *         to add, the absence of the station we are trying to add after, and
     *         null/empty strings.
     */
    public boolean addAfter(String existingStationName, String stationToAdd) {
        boolean success = false;
        // Check if the station to add is already present in the TrainLine
        // object or if the supplied strings are null or empty.
        if (!this.contains(stationToAdd)
                && existingStationName != null && existingStationName.length() > 0
                && stationToAdd != null && stationToAdd.length() > 0) {
            // Traverse the TrainLine, looking for the existing station
            Station current = this.head;
            while (current != null) {
                // Check if the current station is the one we are looking for.
                // If the intended station is not found, we skill the if block,
                // the while-loop eventually ends, and we return the intial
                // value of success which is still false.
                if (current.getName().equals(existingStationName)) {
                    // Intended station found, time to get things going, first
                    // by creating the new station to insert.
                    Station newStation = new Station(stationToAdd);
                    // Make the new station point to where the existing station points
                    newStation.setNext(current.getNext());
                    // Make the existing station point to the new station
                    current.setNext(newStation);
                    // Update the return variable to indicate a successful insertion
                    success = true;
                }
            }
        }
        return success;
    } // method addAfter

} // class TrainLine
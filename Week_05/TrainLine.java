public class TrainLine {
    
    private Station head;

    public void addStation(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            // Make new station the first station for this line
            this.head = newStation;
        } else {
            // There is alread a head station
            // Create a pointer to traverse the line
            Station currentStation = this.head;
            // while we are not there, stay on train
            // and continue one more station down the line
            // "there" = last station ... its next is null
            while (currentStation.hasNext()) {
                currentStation = currentStation.getNext();
            }
            // When loop is over, currentStation is the last station
            currentStation.setNext(newStation);
        }
    }
}

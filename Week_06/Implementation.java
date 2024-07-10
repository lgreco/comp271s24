public class Implementation {
    public static void main(String[] args) {
        TrainLine_Solution redLineSB = new TrainLine_Solution();
        String[] stationNames = {"Howard", "Jarvis", "Morse", 
                                "Loyola", "Granville", "Bryn Mawr"};
        for (String name: stationNames) {
            redLineSB.addStation(name);
        }
        //redLineSB.addAfter("Granville", "Thorndale");
    }
}

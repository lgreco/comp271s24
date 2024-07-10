
public class SimpleTesting {

    private static final String PASS = "Successful";
    private static final String FAIL = "Failed";
    private static final String NON_EXISTENT = "Minas Tirinth";
    public static void main(String[] args) {
        // Create a small train line and add a few stations to it with names
        // drawn from a String[]
        TrainLine_Solution redLineSB = new TrainLine_Solution();
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        for (String name : stationNames) {
            redLineSB.addStation(name);
        }
        // Test sequence
        boolean sequence = true;
        for (int i = 0; i < stationNames.length; i++) {
            sequence = sequence && (redLineSB.indexOf(stationNames[i]) == i);
        }
        System.out.printf("\n\nSequence test: %s", (sequence ? PASS : FAIL));
        // Test non existent
        boolean nonExisting = (redLineSB.indexOf(NON_EXISTENT) == -1);
        System.out.printf("\n\nSequence test: %s", (nonExisting ? PASS : FAIL));

        // another TrainLine and adds new stations.
        TrainLine continueRedLineSB = new TrainLine();
        String[] continueRedLine = {"Granville", "Thorndale", "Bryn Mawr"};
        for (String name : continueRedLine){
            continueRedLineSB.addStation(name);
        }
        // appends the new to the trainline
        redLineSB.append(continueRedLineSB);

        String[] StationsTogether = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale", "Bryn Mawr" };
            boolean appendSuccess = true;
            for (int i = 0; i < StationsTogether.length; i++) {
                appendSuccess = appendSuccess && (redLineSB.indexOf(StationsTogether[i] == i);

                }
                System.out.printf("\n\nAppend test: %s", (appendSuccess ? PASS : FAIL));

                //outputs the final train line 
                System.out.printf("\n\nFinal train line:  %s", redLineSB.toString());
            }
        }



    }
}

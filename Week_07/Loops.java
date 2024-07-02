public class Loops {
    public static void main(String[] args) {

        TrainLine redLineSB = new TrainLine();
        
        Station how = new Station("Howard");
        Station jar = new Station("Jarvis");
        Station mor = new Station("Morse");
        Station loy = new Station("Loyola");
        Station gra = new Station("Granville");
        Station tho = new Station("Thorndale");
        Station bry = new Station("Bryn Mawr");
        Station arg = new Station("Argyle");
        Station wil = new Station("Wilson");

        redLineSB.addStation(how);
        redLineSB.addStation(jar);
        redLineSB.addStation(mor);
        redLineSB.addStation(loy);
        redLineSB.addStation(gra);
        redLineSB.addStation(tho);
        redLineSB.addStation(bry);
        redLineSB.addStation(arg);
        redLineSB.addStation(wil);

        boolean loopy = redLineSB.hasLoop();
        System.out.printf("\n\nLoop present: %s", loopy);
        
        // introduce a loop
        wil.setNext(loy);
        loopy = redLineSB.hasLoop();
        System.out.printf("\n\nLoop present: %s", loopy);
    }
}

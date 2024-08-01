import java.util.Random;

public class HashImplementation {

    public static String[] randomStrings(char firstLetter,
            int minLength,
            int maxLength,
            int count) {
        String[] names = new String[count];
        Random rand = new Random();
                for (int i = 0; i < names.length; i++) {
                    int length = minLength + rand.nextInt(maxLength-minLength);
                    StringBuilder name = new StringBuilder();
                    //name.append(firstLetter);
                    for (int j = 1; j < length; j++) {
                        char charToAppend = (char) (65+rand.nextInt(26));
                        name.append(charToAppend);
                    }
                    names[i] = name.toString();
                }
        return names;
    } // method randomStrings

    public static void main(String[] args) {
        Hash271_Solutions h = new Hash271_Solutions();
        String[] names = randomStrings('A', 5, 1000, 10);
        names[0] = "CAT"; names[1] = "COW";
        for (String name: names) {
            h.put(name);
        }
        System.out.println(h.describe());
    }
}

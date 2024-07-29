import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class KVDemo {

    static Person[] demo;

    public static void main(String[] args) {
        demo = generateRandomPersons(10, 20, 60);
        System.out.println(Arrays.toString(demo));
        System.out.println(searchBySSN(-1));
    }

    public static Person searchBySSN(int ssn) {
        Person found = null;
        int i = 0;
        while (found == null && i < demo.length) {
            if (demo[i].getSSN() == ssn) {
                found = demo[i];
            }
            i++;
        }
        // For illustrative purposes only. No printing allowed
        // in methods with reference types.
        System.out.printf("Search took %d steps... ", i); 
        return found;
    } // method searchBySSN

    /**
     * Generates an array of Person objects with randomly assigned Hobbit-like first
     * names, last names, Social Security Numbers (SSNs), and dates of birth (DOBs).
     * Each will have an age between 18 and 81 years old.
     *
     * @param numberOfPersons the number of Person objects to generate
     * @return an array containing the generated Person objects
     *
     *         GPT prompt: Generate a Java method for the class Person (attached)
     *         that
     *         creates an array of 500 random Person objects. Each Person should
     *         have a randomly assigned Hobbit-like first name, last name, a Social
     *         Security Number (SSN), and a date of birth (DOB). The age of each
     *         Person should be between 18 and 81 years old. Use Javadoc comments to
     *         describe the method.
     */
    public static Person[] generateRandomPersons(int numberOfPersons, int minAge, int maxAge) {
        String[] firstNames = {
                "Frodo", "Samwise", "Bilbo", "Pippin", "Meriadoc", "Rosie", "Lobelia",
                "Fredegar", "Primula", "Gerontius", "Hamfast", "Lotho", "Estella",
                "Adalgrim", "Angelica", "Bungo", "Daisy", "Dudo", "Eglantine", "Esmeralda"
        };
        String[] lastNames = {
                "Baggins", "Gamgee", "Brandybuck", "Took", "Cotton", "Bolger",
                "Proudfoot", "Sackville", "Underhill", "Hornblower", "Banks",
                "Bracegirdle", "Brockhouse", "Brownlock", "Burrows", "Chubb",
                "Goodbody", "Greenhand", "Longholes", "Sandheaver"
        };
        Random random = new Random();
        Person[] persons = new Person[numberOfPersons];
        for (int i = 0; i < numberOfPersons-1; i++) {
            // SSN between 100-00-0000 and 999-99-9999
            int ssn = 100000000 + random.nextInt(900000000);
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = minAge + random.nextInt(maxAge - minAge); // Assume minAge < maxAge
            // Random date within the age range
            LocalDate dob = LocalDate.now().minusYears(age).minusDays(random.nextInt(365));
            persons[i] = new Person(ssn, firstName, lastName, dob);
        }
        // sneaky Leo:
        persons[numberOfPersons-1] = new Person(123456789, firstNames[0], lastNames[0], LocalDate.now());
        return persons;
    } // method generateRandomPersons

} // class KVDemo
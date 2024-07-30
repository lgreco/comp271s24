import java.time.LocalDate;
import java.util.Random;

public class KVDemo {

    public static void main(String[] args) {
        HashTable271<Integer, Person> demo = new HashTable271<>();
        Person[] data = generateRandomPersons(100, 20, 80);
        for (Person person: data) {
            Integer key = person.getSSN();
            demo.put(key, person);
        }
        //System.out.println(demo);
        System.out.println(demo.describe());
    } // method main
   

    /**
     * Generates an array of Person objects with randomly assigned Hobbit-like first
     * names, last names, Social Security Numbers (SSNs), and dates of birth (DOBs).
     * Each will have an age between 18 and 81 years old.
     *
     * @param numberOfPersons the number of Person objects to generate
     * @return an array containing the generated Person objects
     */
    public static Person[] generateRandomPersons(int numberOfPersons, int minAge, int maxAge) {
        // Source array with possible first name
        int SSN_base = 100_000_000;
        String[] firstNames = {
                "Frodo", "Samwise", "Bilbo", "Pippin", "Meriadoc", "Rosie", "Lobelia",
                "Fredegar", "Primula", "Gerontius", "Hamfast", "Lotho", "Estella",
                "Adalgrim", "Angelica", "Bungo", "Daisy", "Dudo", "Eglantine", "Esmeralda"
        };
        // Source array with possible first name
        String[] lastNames = {
                "Baggins", "Gamgee", "Brandybuck", "Took", "Cotton", "Bolger",
                "Proudfoot", "Sackville", "Underhill", "Hornblower", "Banks",
                "Bracegirdle", "Brockhouse", "Brownlock", "Burrows", "Chubb",
                "Goodbody", "Greenhand", "Longholes", "Sandheaver"
        };
        Random random = new Random();
        Person[] persons = new Person[numberOfPersons];
        for (int i = 0; i < numberOfPersons - 1; i++) {
            // SSN between 100-00-0000 and 999-99-9999
            int ssn = SSN_base + i*11;
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = minAge + random.nextInt(maxAge - minAge); // Assume minAge < maxAge
            // Random date within the age range
            LocalDate dob = LocalDate.now().minusYears(age).minusDays(random.nextInt(365));
            persons[i] = new Person(ssn, firstName, lastName, dob);
        }
        // sneaky Leo:
        persons[numberOfPersons - 1] = new Person(999999999, firstNames[0], lastNames[0], LocalDate.now());
        return persons;
    } // method generateRandomPersons

} // class KVDemo
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int ssn;

    public Person(int ssn, String firstName, String lastName, LocalDate dob) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDOB() {
        return this.dob;
    }

    public int getSSN() {
        return this.ssn;
    }

    public int age() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public String toString() {
        return String.format("\n[%10d: %-9s | %-11s | %11s (%2d)]",
                this.ssn,
                this.firstName,
                this.lastName,
                this.dob.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                this.age());
    }

}

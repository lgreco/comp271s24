import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    final private String firstName;
    final private String lastName;
    final private LocalDate dob;
    final private int ssn;

    public Person(final int ssn, final String firstName, final String lastName, final LocalDate dob) {
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

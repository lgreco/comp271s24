package Week_04;

public class Undergrad extends Student {
    String academicMinor;

    public String toString() {
        return this.name + ", " + this.academicMajor + ", " + this.academicMinor;
    }
}

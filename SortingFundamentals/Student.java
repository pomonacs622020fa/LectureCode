/**
 * Student
 */
public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int idNumber;
    private static int ID_NUMBER = 0;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = ID_NUMBER;
        ID_NUMBER++;
    }

    public String toString() {
        return lastName + ", " + firstName + " (" + idNumber + ")";
    }

    @Override
    public int compareTo(Student that) {
        // Return 0 if they are equal
        // Return 1 if this is greater than that
        // Return -1 if this is less than that
        return this.lastName.compareTo(that.lastName);
    }
}

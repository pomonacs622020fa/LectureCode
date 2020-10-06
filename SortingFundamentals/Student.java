import java.util.UUID;

/**
 * Student
 */
public class Student implements Comparable<Student> {

    UUID uuid;
    private int idNumber;
    private static int ID_NUMBER = 0;

    public Student(UUID uuid) {
        this.uuid = uuid;
        this.idNumber = ID_NUMBER;
        ID_NUMBER++;
    }

    public String toString() {
        return uuid + " (" + idNumber + ")";
    }

    @Override
    public int compareTo(Student that) {
        // Return 0 if they are equal
        // Return >=1 if this is greater than that
        // Return <=-1 if this is less than that
        return this.uuid.compareTo(that.uuid);
    }
}

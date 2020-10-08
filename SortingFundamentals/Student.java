import java.util.Random;
import java.util.UUID;

public class Student implements Comparable<Student> {

    UUID uuid;
    private int idNumber;
    private Integer idRandom;
    private static int ID_NUMBER = 0;

    public Student(UUID uuid, Random r) {
        this.uuid = uuid;
        this.idNumber = ID_NUMBER;
        this.idRandom = r.nextInt(4);
        ID_NUMBER++;
    }

    public String toString() {
        return idRandom + " (" + idNumber + ")";
    }

    @Override
    public int compareTo(Student that) {
        // Return 0 if they are equal
        // Return >=1 if this is greater than that
        // Return <=-1 if this is less than that
        return idRandom.compareTo(that.idRandom);
    }
}

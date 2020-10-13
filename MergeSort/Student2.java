
public class Student2 implements Comparable<Student2> {

    private Integer idNumber;
    private String firstName;
    private String lastName;

    private static String SORT_KEY = "last";
    private static int ID_NUMBER = 0;

    public Student2(String fn, String ln) {
        firstName = fn;
        lastName = ln;
        idNumber = ID_NUMBER;
        ID_NUMBER++;
    }

    public String toString() {
        return lastName + ", " + firstName + " (" + idNumber + ")";
    }

    @Override
    public int compareTo(Student2 that) {
        // Return 0 if they are equal
        // Return >=1 if this is greater than that
        // Return <=-1 if this is less than that

        if (SORT_KEY.equals("last")) {
            return lastName.compareTo(that.lastName);
        } else if (SORT_KEY.equals("first")) {
            return firstName.compareTo(that.firstName);
        } else {
            return idNumber.compareTo(that.idNumber);
        }
    }

    public static void sortByLast() {
        SORT_KEY = "last";
    }

    public static void sortByFirst() {
        SORT_KEY = "first";
    }

    public static void sortByID() {
        SORT_KEY = "id";
    }
}

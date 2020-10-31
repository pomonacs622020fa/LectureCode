import java.util.ArrayList;
import java.util.HashMap;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object that) {
        // Check references
        if (this == that) {
            return true;
        }

        if (that == null) {
            return false;
        }

        // Different classes might have the same members,
        // but they should not be equal
        if (this.getClass() != that.getClass()) {
            return false;
        }

        Date thatDate = (Date) that;

        // Use
        // == for primitive types
        // equals() for objects
        // Arrays.equals() for arrays primitives
        // Arrays.deepEquals() for arrays of objects

        // return this.month == thatDate.month;
        return this.month == thatDate.month && this.day == thatDate.day;
    }

    @Override
    public int hashCode() {
        // Use
        // hashCode() for primite types (requires cast)
        // hash() for object fields
        // Arrays.hashCode() for primitive arrays
        // Arrays.deepHashCode for object arrays
        int hash = 1;
        hash = 31 * hash + ((Integer) month).hashCode();
        hash = 31 * hash + ((Integer) day).hashCode();
        return hash;
    }

    static void putInHashMap(HashMap<Date, ArrayList<String>> hashtable, Date date, String name) {
        if (hashtable.get(date) == null) {
            hashtable.put(date, new ArrayList<>());
        }
        hashtable.get(date).add(name);
    }

    public static void main(String[] args) {
        HashMap<Date, ArrayList<String>> birthdays = new HashMap<>();

        putInHashMap(birthdays, new Date(1732, 2, 22), "George Washington");
        putInHashMap(birthdays, new Date(1735, 10, 30), "John Adams");
        putInHashMap(birthdays, new Date(1743, 4, 13), "Thomas Jefferson");
        putInHashMap(birthdays, new Date(1751, 3, 16), "James Madison");
        putInHashMap(birthdays, new Date(1758, 4, 28), "James Monroe");
        putInHashMap(birthdays, new Date(1767, 7, 11), "John Quincy Adams");
        putInHashMap(birthdays, new Date(1795, 11, 2), "James K. Polk");
        putInHashMap(birthdays, new Date(1865, 11, 2), "Warren G. Harding");
        putInHashMap(birthdays, new Date(1790, 3, 29), "John Tyler");

        // Demos
        // (1) Try without equals and hashCode
        // (2) Try with month only comparison
        // (3) Try with month and day
        for (Date date : birthdays.keySet()) {
            System.out.println(birthdays.get(date).size());
        }
    }

}

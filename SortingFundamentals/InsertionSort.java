import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * InsertionSort
 */
public class InsertionSort {

    /**
     * 1. Divide the array into two parts: (left) a sorted subarray and (right) an
     * unsorted subarray.
     *
     * 2. Repeat
     *
     * ---- 1. Take the leftmost element of the unsorted subarray.
     *
     * ---- 2. Insert this element into its correct position in the sorted subarray.
     *
     * ---- 3. Shift subarray boundaries one to the right.
     *
     * @param students
     */
    public static <T extends Comparable<T>> void Sort(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j).compareTo(list.get(j - 1)) < 0) {
                    T temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Random r = new Random();

        ArrayList<Student> students = new ArrayList<Student>();
        int numStudents = 10;
        for (int i = 0; i < numStudents; i++) {
            students.add(new Student(UUID.randomUUID(), r));
            System.out.println(students.get(i));
        }

        Sort(students);

        System.out.println();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}

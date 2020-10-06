import java.util.ArrayList;
import java.util.UUID;

/**
 * SelectionSort
 */
public class SelectionSort {

    /**
     * 1. Divide the array into two parts: (left) a sorted subarray and (right) an
     * unsorted subarray.
     *
     * 2. Repeat
     *
     * ---- 1. Find the smallest element in the unsorted subarray.
     *
     * ---- 2. Swap it with the leftmost unsorted element.
     *
     * ---- 3. Shift subarray boundaries one to the right.
     *
     * @param students
     */
    public static <T extends Comparable<T>> void Sort(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            T temp = list.get(i);
            list.set(i, list.get(indexOfMin));
            list.set(indexOfMin, temp);
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();
        int numStudents = 10;
        for (int i = 0; i < numStudents; i++) {
            students.add(new Student(UUID.randomUUID()));
            System.out.println(students.get(i));
        }

        Sort(students);

        System.out.println();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}

/**
 * MergeSort
 */
public class MergeSort {

    public static <T extends Comparable<T>> void merge(T[] array, T[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // If we've already copied everything from lo ..= mid
            if (i > mid) {
                array[k] = aux[j++];
            }
            // If we've already copied everything from mid+1 ..= hi
            else if (j > hi) {
                array[k] = aux[i++];
            }
            // If aux[j] < aux[i]
            else if (aux[j].compareTo(aux[i]) < 0) {
                array[k] = aux[j];
                j++;
            }
            // If aux[j] >= aux[i]
            else {
                array[k] = aux[i++];
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array, T[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        // T(n) = O(n lg n)
        // M(n) = O(n)
        @SuppressWarnings("unchecked")
        T[] auxiliary = (T[]) new Comparable[array.length];
        sort(array, auxiliary, 0, array.length - 1);
    }

    public static void main(String[] args) {

        String[] randomNames = { "Marnie Coil", "Calandra Goll", "Floria Radley", "Zaida Carty", "Sherry Riesgo",
                "Eldon Plain", "Flavia Aceto", "Jacqualine Montes", "Deandrea Preciado", "Laurie Keech",
                "Chantal Corzine", "Kassandra Wiley", "Elba Haase", "Elli Warburton", "Caron Charney", "Sophie Gamino",
                "Gordon Feuerstein", "Mandi Burroughs", "Roselle Mcquillen", "Garland Kroeger" };

        Student2[] students = new Student2[randomNames.length];
        for (int i = 0; i < students.length; i++) {
            String[] firstLast = randomNames[i].split(" ");
            students[i] = new Student2(firstLast[0], firstLast[1]);
            System.out.println(students[i]);
        }

        // Student2.sortByFirst();
        sort(students);

        System.out.println();
        for (Student2 student : students) {
            System.out.println(student);
        }
    }
}

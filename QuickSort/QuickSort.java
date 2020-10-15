import java.util.Random;

/**
 * QuickSort
 */
public class QuickSort {

    /**
     * Swap two values in a given array.
     *
     * @param array: array with values to swap
     * @param a:     index of one value
     * @param b:     index of second value
     */
    private static <T extends Comparable<T>> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Generate a random number in the range min ..< max
     *
     * @param min: inclusive lower bound
     * @param max: exclusive upper bound
     * @return a random number
     */
    private static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

    /**
     * Partition elements into a "less-than" partition and a
     * "greater-than-or-equal-to" partition.
     *
     * @param array: array to partition
     * @param lo:    lowest index of subarray, and the index of the pivot
     * @param hi:    exclusive upper bound of subarray
     * @return the index of the pivot after partitioning
     */
    private static <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {
        T pivot = array[lo];

        int i = lo + 1;
        for (int j = lo + 1; j < hi; j++) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, i, j);
                i++;
            }
        }

        int pivotIndex = i - 1;
        swap(array, lo, pivotIndex);
        return pivotIndex;
    }

    /**
     * Sort the given array using the QuickSort algorithm
     *
     * @param array: array to sort
     * @param lo:    lower bound on subarray
     * @param hi:    exclusive upper bound on subarray
     */
    public static <T extends Comparable<T>> void sort(T[] array, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }

        // Swap a pivot value into place
        int randomIndex = randRange(lo, hi);
        swap(array, lo, randomIndex);

        int mid = partition(array, lo, hi);

        sort(array, lo, mid);
        sort(array, mid + 1, hi);
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length);
    }

    public static void main(String[] args) {

        Integer[] classExample = { 3, 43, 16, -1, 17, 27, 2, 0 };
        sort(classExample);

        String[] characters = "QuickSort".toLowerCase().split("");
        sort(characters);

        Integer[] ints = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            ints[i] = randRange(-100, 100);
        }
        sort(ints);

        // Check that values are sorted
        for (int i = 1; i < ints.length; i++) {
            if (ints[i - 1] > ints[i]) {
                System.out.println("Not sorted");
                break;
            }
        }
    }
}

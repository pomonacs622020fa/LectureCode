import java.util.Random;

/**
 * QuickSort
 */
public class QuickSort {

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
     * @return
     */
    private static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

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

    public static <T extends Comparable<T>> void sort(T[] array, int lo, int hi) {
        if (lo >= hi) {
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
        String[] characters = "QuickSort".toLowerCase().split("");
        sort(characters);

        Integer[] ints = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            ints[i] = randRange(-100, 100);
        }
        sort(ints);
    }
}

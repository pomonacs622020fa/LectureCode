import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int numInts = 16;
        Integer[] randInts = new Integer[numInts];

        int maxInt = 1024;
        Random rand = new Random();

        for (int i = 0; i < randInts.length; i++) {
            randInts[i] = rand.nextInt(maxInt);
        }

        System.out.println(Arrays.toString(randInts));
        MaxHeap<Integer> heap = new MaxHeap<>(randInts);
        System.out.println(heap);
        heap.sort();
        System.out.println(heap);
    }
}

/**
 * MaxHeap
 */
public class MaxHeap<Key extends Comparable<Key>> {

    private Key[] data; // underlying array of items
    private int size; // number of items in arraylist

    public MaxHeap(int capacity) {
        // Workaround to remove warning
        @SuppressWarnings("unchecked")
        Key[] tmp = (Key[]) new Comparable[capacity];
        data = tmp;
        size = 0;
    }

    private void swap(int a, int b) {
        Key temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int left(int k) {
        return k * 2 + 1;
    }

    private int right(int k) {
        return k * 2 + 2;
    }

    private boolean less(int a, int b) {
        return data[a].compareTo(data[b]) < 0;
    }

    private boolean greater(int a, int b) {
        return !less(a, b);
    }

    private void bubbleLeft(int k) {
        int parentIndex = parent(k);
        while (k > 0 && greater(k, parentIndex)) {
            swap(k, parentIndex);
            k = parentIndex;
            parentIndex = parent(k);
        }
    }

    public void insert(Key newKey) {
        if (size == data.length) {
            throw new IndexOutOfBoundsException("No more room.");
        }
        data[size] = newKey;
        bubbleLeft(size);
        size++;
    }

    private int getLargerChildIndex(int k) {
        int leftIndex = left(k);
        int rightIndex = right(k);
        boolean takeLeft = rightIndex >= size || greater(leftIndex, rightIndex);
        return takeLeft ? leftIndex : rightIndex;
    }

    private void bubbleRight(int k) {
        while (2 * k + 1 < size) {
            int childIndex = getLargerChildIndex(k);
            if (greater(k, childIndex)) {
                break;
            }
            swap(k, childIndex);
            k = childIndex;
        }
    }

    public Key extractMax() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Nothing to extract.");
        }
        Key maxKey = data[0];
        data[0] = data[--size];
        data[size] = null;
        bubbleRight(0);
        return maxKey;
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder("[ ");
        String sep = "";
        for (int i = 0; i < size; i++) {
            stringBuffer.append(sep + data[i]);
            sep = ", ";
        }
        sep = sep + "∅";
        for (int i = size; i < data.length; i++) {
            stringBuffer.append(sep);
            sep = ", ∅";
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public MaxHeap(Key[] items) {
        data = items;
        size = items.length;
        heapify();
    }

    private void heapify() {
        // Bubble non-leaves to the right
        for (int k = size / 2; k >= 0; k--) {
            bubbleRight(k);
        }
    }

    public void sort() {
        int originalSize = size;
        while (size > 0) {
            swap(0, --size);
            bubbleRight(0);
        }
        size = originalSize;
    }

    public static void main(String[] args) {
        Integer[] ints = { 100, 19, 36, 17, 3, 25, 1, 2, 7 };

        MaxHeap<Integer> heap = new MaxHeap<>(ints.length);

        for (Integer i : ints) {
            heap.insert(i);
            System.out.println(heap);
        }

        while (!heap.empty()) {
            Integer i = heap.extractMax();
            System.out.println(heap + " --> " + i);
        }
    }
}

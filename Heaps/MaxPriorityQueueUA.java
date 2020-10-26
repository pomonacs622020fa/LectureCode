public class MaxPriorityQueueUA<Key extends Comparable<Key>> {
    private Key[] data;
    private int size;

    public MaxPriorityQueueUA(int capacity) {
        data = (Key[]) new Comparable[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key key) {
        data[size++] = key;
    }

    public Key extractMax() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        Key maxKey = data[max];
        data[max] = data[size - 1];
        size--;
        return maxKey;
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
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

    public static void main(String[] args) {
        MaxPriorityQueueUA<Character> pq = new MaxPriorityQueueUA<>(10);

        pq.insert('P');
        System.out.println("Inserted  'P': " + pq);
        pq.insert('Q');
        System.out.println("Inserted  'Q': " + pq);
        pq.insert('E');
        System.out.println("Inserted  'E': " + pq);
        System.out.println("Extracted '" + pq.extractMax() + "': " + pq);
        pq.insert('X');
        System.out.println("Inserted  'X': " + pq);
        pq.insert('A');
        System.out.println("Inserted  'A': " + pq);
        pq.insert('M');
        System.out.println("Inserted  'M': " + pq);
        System.out.println("Extracted '" + pq.extractMax() + "': " + pq);
        pq.insert('P');
        System.out.println("Inserted  'P': " + pq);
        pq.insert('L');
        System.out.println("Inserted  'L': " + pq);
        pq.insert('E');
        System.out.println("Inserted  'E': " + pq);
        System.out.println("Extracted '" + pq.extractMax() + "': " + pq);
    }
}

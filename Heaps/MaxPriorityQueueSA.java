public class MaxPriorityQueueSA<Key extends Comparable<Key>> {
    private Key[] data;
    private int size;

    public MaxPriorityQueueSA(int capacity) {
        data = (Key[]) (new Comparable[capacity]);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key key) {
        int i = size - 1;
        while (i >= 0 && less(key, data[i])) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = key;
        size++;
    }

    public Key extractMax() {
        return data[--size];
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
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
        MaxPriorityQueueSA<Character> pq = new MaxPriorityQueueSA<>(10);

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

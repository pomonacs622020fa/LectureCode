public class MaxHeapPQDemo {
    public static void main(String[] args) {
        MaxHeap<Character> pq = new MaxHeap<>(10);

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

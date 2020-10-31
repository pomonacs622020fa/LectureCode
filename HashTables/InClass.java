import java.util.HashMap;

public class InClass {

    public static int hash(String key, int m) {
        // DJB2 hash function
        int value = 5381;
        int magic = 33;
        for (int i = 0; i < key.length(); i++) {
            value = value * magic + (int) key.charAt(i);
        }
        return (value & 0xFFFFFFFF) % m;
    }

    public static void main(String[] args) {

        int m = 97; // and n = 10; you're going to get a lot of collisions!

        // Array
        Integer[] arrayOfInts = new Integer[m];
        arrayOfInts[0] = 101;
        arrayOfInts[5] = 202;

        System.out.println(arrayOfInts[0] + " " + arrayOfInts[5]);

        // HashMap
        HashMap<String, Integer> mapOfInts = new HashMap<>();
        mapOfInts.put("zero", 101);
        mapOfInts.put("five", 202);

        System.out.println(mapOfInts.get("zero") + " " + mapOfInts.get("five"));

        // Mixed
        Integer[] arrayMap = new Integer[m];
        arrayMap[hash("zero", m)] = 101;
        arrayMap[hash("five", m)] = 202;

        System.out.println(arrayMap[hash("zero", m)] + " " + arrayMap[hash("five", m)]);

        // Mixed version with more items
        String[] array3 = new String[m];
        array3[hash("one", m)] = "a";
        array3[hash("two", m)] = "b";
        array3[hash("three", m)] = "c";
        array3[hash("four", m)] = "d";
        array3[hash("five", m)] = "e";
        array3[hash("six", m)] = "f";
        array3[hash("seven", m)] = "g";
        array3[hash("eight", m)] = "h";
        array3[hash("nine", m)] = "i";
        array3[hash("ten", m)] = "j";

        // 100% * 90% * 80%

        // What do you expect to be printed
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }

    }
}

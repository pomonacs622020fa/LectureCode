import java.util.HashMap;

public class CompareWithArrayList {

    public static int hash(String key, int n) {
        // DJB2 hash function
        int value = 5381;
        int magic = 33;
        for (int i = 0; i < key.length(); i++) {
            value = value * magic + (int) key.charAt(i);
        }
        return (value & 0xFFFFFFFF) % n;
    }

    public static void main(String[] args) {
        // Normal array
        String[] array = new String[10];
        array[0] = "CS 62";
        array[5] = "Data Structures";
        System.out.println(array[0] + " " + array[5]);

        // Hash table with Integers as keys
        HashMap<Integer, String> hashtable = new HashMap<>();
        hashtable.put(0, "CS 62");
        hashtable.put(5, "Data Structures");
        System.out.println(hashtable.get(0) + " " + hashtable.get(5));

        // Hash table with Strings as keys
        HashMap<String, String> hashtable2 = new HashMap<>();
        hashtable2.put("one", "CS 62");
        hashtable2.put("five", "Data Structures");
        System.out.println(hashtable2.get("one") + " " + hashtable2.get("five"));

        // Normal array with Strings as indices (kind of)
        int m = 10;
        String[] array2 = new String[m];
        array2[hash("one", m)] = "CS 62";
        array2[hash("five", m)] = "Data Structures";
        System.out.println(array2[hash("one", m)] + " " + array2[hash("five", m)]);

        // Any problems with the array above?
        String[] array3 = new String[m];
        array2[hash("one", m)] = "a";
        array2[hash("two", m)] = "b";
        array2[hash("three", m)] = "c";
        array2[hash("four", m)] = "d";
        array2[hash("five", m)] = "e";
        array2[hash("six", m)] = "f";
        array2[hash("seven", m)] = "g";
        array2[hash("eight", m)] = "h";
        array2[hash("nine", m)] = "i";
        array2[hash("ten", m)] = "j";

        // What do you expect to be printed
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array2[i]);
        }
    }
}

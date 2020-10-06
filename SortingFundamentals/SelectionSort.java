/**
 * SelectionSort
 */
public class SelectionSort {

    /**
     * 1. Divide the array into two parts: (left) a sorted subarray and (right) an
     * unsorted subarray. 2. Repeat 1. Find the smallest element in the unsorted
     * subarray. 2. Swap it with the leftmost unsorted element. 3. Shift subarray
     * boundaries one to the right.
     *
     * @param students
     */
    public static void Sort(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < students.length; j++) {
                if (students[j].compareTo(students[i]) < 0) {

                }
            }
        }

    }

    public static void main(String[] args) {
        Student gabriel = new Student("Gabriel", "Konar-Steenberg");
        Student millie = new Student("Millie", "Mince");
        Student ziang = new Student("Ziang", "Xue");

        Student[] studentArray = new Student[3];
        studentArray[0] = gabriel;
        studentArray[1] = millie;
        studentArray[2] = ziang;

        for (int i = 0; i < studentArray.length; i++) {
            System.out.println(studentArray[i]);
        }

        Sort(studentArray);

        System.out.println();

        for (int i = 0; i < studentArray.length; i++) {
            System.out.println(studentArray[i]);
        }

    }

}

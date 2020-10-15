import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 * Student
 */
public class StudentCompAndIter implements Comparable<StudentCompAndIter>, Iterable<Integer> {

    private char firstInitial;
    private char lastInitial;

    private int[] scores;
    private int maxScore;
    private double averageScore;

    public StudentCompAndIter() {
        Random random = new Random();
        firstInitial = (char) (random.nextInt(26) + (int) 'a');
        lastInitial = (char) (random.nextInt(26) + (int) 'a');

        int numScores = random.nextInt(10) + 2;
        scores = new int[numScores];

        maxScore = 0;
        averageScore = 0;

        for (int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(50) + 50;
            averageScore += scores[i];
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        averageScore /= scores.length;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, %s (%d, %.02f)", lastInitial, firstInitial, maxScore, averageScore);
    }

    @Override
    public int compareTo(StudentCompAndIter that) {
        if (lastInitial < that.lastInitial) {
            return -1;
        } else if (lastInitial == that.lastInitial && firstInitial < that.firstInitial) {
            return -1;
        } else if (lastInitial == that.lastInitial && firstInitial == that.firstInitial) {
            return 0;
        } else {
            return 1;
        }
    }

    public static Comparator<StudentCompAndIter> avgComparator = new Comparator<StudentCompAndIter>() {
        @Override
        public int compare(StudentCompAndIter a, StudentCompAndIter b) {
            if (Math.abs(a.averageScore - b.averageScore) < 0.01) {
                return 0;
            } else if (a.averageScore < b.averageScore) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    public static Comparator<StudentCompAndIter> maxComparator = new Comparator<StudentCompAndIter>() {
        @Override
        public int compare(StudentCompAndIter a, StudentCompAndIter b) {
            return a.maxScore - b.maxScore;
        }
    };

    private class StudentIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < scores.length;
        }

        @Override
        public Integer next() {
            return scores[index++];
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new StudentIterator();
    }

    private static void print_students(ArrayList<StudentCompAndIter> students) {
        for (StudentCompAndIter student : students) {
            System.out.print(student + " Scores: ");
            for (Integer score : student) {
                System.out.print(score + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int NUM_STUDENTS = 8;
        ArrayList<StudentCompAndIter> students = new ArrayList<>(NUM_STUDENTS);
        for (int i = 0; i < NUM_STUDENTS; i++) {
            students.add(new StudentCompAndIter());
        }

        System.out.println("Before sort.");
        print_students(students);

        Collections.sort(students);
        System.out.println("\nAfter sort with 'compareTo'.");
        print_students(students);

        Collections.sort(students, StudentCompAndIter.avgComparator);
        System.out.println("\nAfter sort with 'avgComparator'.");
        print_students(students);

        Collections.sort(students, StudentCompAndIter.maxComparator);
        System.out.println("\nAfter sort with 'maxComparator'.");
        print_students(students);

    }
}

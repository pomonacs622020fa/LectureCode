import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Student
 */
public class StudentComp implements Comparable<StudentComp> {

    private char firstInitial;
    private char lastInitial;

    private int[] scores;
    private int maxScore;
    private double averageScore;

    public StudentComp() {
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
    public int compareTo(StudentComp that) {
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

    public static Comparator<StudentComp> avgComparator = new Comparator<StudentComp>() {
        @Override
        public int compare(StudentComp a, StudentComp b) {
            if (Math.abs(a.averageScore - b.averageScore) < 0.01) {
                return 0;
            } else if (a.averageScore < b.averageScore) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    public static Comparator<StudentComp> maxComparator = new Comparator<StudentComp>() {
        @Override
        public int compare(StudentComp a, StudentComp b) {
            return a.maxScore - b.maxScore;
        }
    };

    private static void print_students(ArrayList<StudentComp> students) {
        for (StudentComp student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        int NUM_STUDENTS = 8;
        ArrayList<StudentComp> students = new ArrayList<>(NUM_STUDENTS);
        for (int i = 0; i < NUM_STUDENTS; i++) {
            students.add(new StudentComp());
        }

        System.out.println("Before sort.");
        print_students(students);

        Collections.sort(students);
        System.out.println("\nAfter sort with 'compareTo'.");
        print_students(students);

        Collections.sort(students, StudentComp.avgComparator);
        System.out.println("\nAfter sort with 'avgComparator'.");
        print_students(students);

        Collections.sort(students, StudentComp.maxComparator);
        System.out.println("\nAfter sort with 'maxComparator'.");
        print_students(students);

    }
}

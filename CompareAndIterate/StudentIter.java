import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Student
 */
public class StudentIter implements Iterable<Integer> {

    private char firstInitial;
    private char lastInitial;

    private int[] scores;
    private int maxScore;
    private double averageScore;

    public StudentIter() {
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

    private static void print_students(ArrayList<StudentIter> students) {
        for (StudentIter student : students) {
            System.out.print(student + " Scores: ");
            for (Integer score : student) {
                System.out.print(score + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int NUM_STUDENTS = 8;
        ArrayList<StudentIter> students = new ArrayList<>(NUM_STUDENTS);
        for (int i = 0; i < NUM_STUDENTS; i++) {
            students.add(new StudentIter());
        }

        print_students(students);
    }
}

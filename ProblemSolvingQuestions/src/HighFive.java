import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*High Five

 Given a list of scores of different students,
 return the average score of each student's top five scores in the order of each student's id.

 Each entry items{i} has items{i}{0} the student's id, and items{i}{1} the student's score.
 The average score is calculated using integer division.


 Example 1:

 Input: {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}}
 Output: {{1,87},{2,88}}
 Explanation:
     The average of the student with id = 1 is 87.
     The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.


 Note:

     1 <= items.length <= 1000
     items{i}.length == 2
     The IDs of the students is between 1 to 1000
     The score of the students is between 1 to 100
     For each student, there are at least 5 scores*/
public class HighFive {
    public static void main(String[] args) {
        int[][] input = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        System.out.println(highFive(input));
    }

    public static int[][] highFive(int[][] marklist) {
        Map<Integer, PriorityQueue<Integer>> structuredMarklist = new HashMap<>();
        for (int[] record : marklist) {
            int student = record[0];
            if (structuredMarklist.containsKey(student)) {
                structuredMarklist.get(student).add(record[1]);
            } else {
                PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
                que.add(record[1]);
                structuredMarklist.put(student, que);
            }
        }
        int[][] output = new int[structuredMarklist.size()][2];
        int idx = 0;
        for (int student : structuredMarklist.keySet()) {
            int avg = 0;
            for (int i = 0; i < 5; i++) {
                avg += structuredMarklist.get(student).poll();
            }
            avg = avg / 5;
            output[idx] = new int[]{student, avg};
            idx++;
        }
        return output;
    }
}

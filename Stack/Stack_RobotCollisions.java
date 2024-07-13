import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stack_RobotCollisions {
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

    int n = positions.length;
    Integer indices[] = new Integer[n];
    List<Integer> ans = new ArrayList<>();
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < n; i++) {
      indices[i] = i;
    }

    Arrays.sort(indices, (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs]));

    for (int roboInd : indices) {

      // Add the right-moving robots to the stack
      if (directions.charAt(roboInd) == 'R') {
        stk.push(roboInd);
      } else {

        while (!stk.isEmpty() && healths[roboInd] > 0) {

          // Pop the right most robot from the stack for collision check
          int rightRoboInd = stk.pop();

          if (healths[roboInd] > healths[rightRoboInd]) {
            // Current robot survives, right most robot is destroyed
            healths[roboInd]--;
            healths[rightRoboInd] = 0;
          } else if (healths[roboInd] < healths[rightRoboInd]) {
            // right most robot survives, current robot is destroyed
            healths[rightRoboInd]--;
            healths[roboInd] = 0;
            stk.push(rightRoboInd);
          } else {
            // Both robots are destroyed
            healths[roboInd] = healths[rightRoboInd] = 0;
          }

        }

      }

    }

    // obtaining the desired results
    for (int i = 0; i < n; i++) {
      if (healths[i] > 0) {
        ans.add(healths[i]);
      }
    }

    return ans;
  }
}

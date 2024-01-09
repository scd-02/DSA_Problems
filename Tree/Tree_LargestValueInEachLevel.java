import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * i/p: 10 5 6 4 3 9 2
 * o/p: 10 6 9
 */

public class Tree_LargestValueInEachLevel {
  public ArrayList<Integer> largestValues(Node root) {

    Deque<Node> q = new LinkedList<>();
    ArrayList<Integer> max = new ArrayList<>();

    q.add(root);
    max.add(root.data);

    while (!q.isEmpty()) {
      int size = q.size();
      int largest = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        Node u = q.poll();
        if (u.left != null) {
          largest = Math.max(largest, u.left.data);
          q.add(u.left);
        }
        if (u.right != null) {
          largest = Math.max(largest, u.right.data);
          q.add(u.right);
        }
      }
      max.add(largest);
    }
    max.remove(max.size() - 1);
    return max;
  }
}

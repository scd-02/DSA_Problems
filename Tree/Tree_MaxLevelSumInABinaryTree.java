import java.util.Deque;
import java.util.LinkedList;

public class Tree_MaxLevelSumInABinaryTree {
  public int maxLevelSum(Node root) {

    Deque<Node> q = new LinkedList<>();
    q.add(root);

    int sum = root.data;
    int maxSum = root.data;

    while (!q.isEmpty()) {
      int size = q.size();
      maxSum = Math.max(sum, maxSum);
      sum = 0;
      for (int i = 0; i < size; i++) {
        Node u = q.poll();
        if (u.left != null) {
          q.add(u.left);
          sum += u.left.data;
        }
        if (u.right != null) {
          q.add(u.right);
          sum += u.right.data;
        }
      }
    }

    return maxSum;
  }
}

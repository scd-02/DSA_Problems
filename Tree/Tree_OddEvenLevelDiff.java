import java.util.Deque;
import java.util.LinkedList;

/*
 * i/p: 10 20 30 40 60
 * o/p: (10+40+60) - (20+30) = 60
 */

public class Tree_OddEvenLevelDiff {
  int getLevelDiff(Node root) {
    if (root == null) {
      return 0;
    }

    Deque<Node> q = new LinkedList<>();
    q.add(root);
    int level = 1;
    int evenSum = 0, oddSum = root.data;

    while (!q.isEmpty()) {
      level++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node u = q.poll();
        if ((level & 1) == 0) {
          if (u.left != null) {
            evenSum += u.left.data;
            q.add(u.left);
          }
          if (u.right != null) {
            evenSum += u.right.data;
            q.add(u.right);
          }
        } else {
          if (u.left != null) {
            oddSum += u.left.data;
            q.add(u.left);
          }
          if (u.right != null) {
            oddSum += u.right.data;
            q.add(u.right);
          }
        }
      }
    }
    return oddSum - evenSum;
  }
}

import java.util.LinkedList;
import java.util.Queue;

public class Tree_LeafUnderBudget {
  public int getCount(Node node, int bud) {
    Queue<Node> q = new LinkedList<>();
    q.add(node);

    int level = 1;
    int count = 0;

    while (!q.isEmpty()) {

      int size = q.size();
      for (int i = 1; i <= size; i++) {

        Node u = q.poll();
        if (u.left == null && u.right == null && bud >= level) {
          count++;
          bud = bud - level;
        }

        if (u.left != null) {
          q.add(u.left);
        }

        if (u.right != null) {
          q.add(u.right);
        }

      }

      level++;

    }

    return count;

  }
}

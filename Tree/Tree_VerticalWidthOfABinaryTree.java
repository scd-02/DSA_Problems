import java.util.LinkedList;
import java.util.Queue;

public class Tree_VerticalWidthOfABinaryTree {
  class Pair {
    Node node;
    int axis;

    Pair(Node node, int axis) {
      this.node = node;
      this.axis = axis;
    }
  }

  public int verticalWidth(Node root) {

    if (root == null)
      return 0;

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));

    int min = 0;
    int max = 0;

    while (!q.isEmpty()) {

      Pair p = q.poll();
      Node u = p.node;
      int axis = p.axis;

      if (u.left != null) {
        q.add(new Pair(u.left, axis - 1));
        min = Math.min(axis - 1, min);
      }

      if (u.right != null) {
        q.add(new Pair(u.right, axis + 1));
        max = Math.max(axis + 1, max);
      }

    }

    return max - min + 1;
  }
}

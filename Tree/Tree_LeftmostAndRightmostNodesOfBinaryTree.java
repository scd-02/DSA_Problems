import java.util.LinkedList;
import java.util.Queue;

public class Tree_LeftmostAndRightmostNodesOfBinaryTree {
  public static void printCorner(Node node) {

    Queue<Node> q = new LinkedList<>();
    q.add(node);

    while (!q.isEmpty()) {

      int size = q.size();

      for (int i = 1; i <= size; i++) {

        Node u = q.poll();

        if (i == 1 || i == size) {
          System.out.print(u.data + " ");
        }

        if (u.left != null) {
          q.add(u.left);
        }

        if (u.right != null) {
          q.add(u.right);
        }

      }

    }

  }
}

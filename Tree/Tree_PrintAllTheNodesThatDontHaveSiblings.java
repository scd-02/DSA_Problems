import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_PrintAllTheNodesThatDontHaveSiblings {
  class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  ArrayList<Integer> noSibling(Node node) {

    Queue<Node> q = new LinkedList<>();
    q.add(node);

    ArrayList<Integer> ans = new ArrayList<>();

    while (!q.isEmpty()) {

      int size = q.size();

      for (int i = 0; i < size; i++) {
        Node u = q.poll();

        if (u.left != null) {
          q.add(u.left);
          if (u.right == null) {
            ans.add(u.left.data);
          }
        }

        if (u.right != null) {
          q.add(u.right);
          if (u.left == null) {
            ans.add(u.right.data);
          }
        }
      }

    }

    if (ans.size() == 0) {
      ans.add(-1);
    }

    Collections.sort(ans);

    return ans;
  }
}

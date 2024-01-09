import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Tree_ZigZigTraversal {

  // i/p: 1 2 3 N N 5 6
  // o/p: 1 3 2 5 6

  ArrayList<Integer> zigZagTraversal(Node root) {

    ArrayList<Integer> ans = new ArrayList<>();
    Deque<Node> q = new LinkedList<>();

    q.add(root);
    ans.add(root.data);

    int level = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      level++;
      for (int i = 0; i < size; i++) {
        if ((level & 1) != 0) {
          Node u = q.removeLast();
          if (u.right != null) {
            q.addFirst(u.right);
            ans.add(u.right.data);
          }
          if (u.left != null) {
            q.addFirst(u.left);
            ans.add(u.left.data);
          }
        } else {
          Node u = q.poll();
          if (u.left != null) {
            q.add(u.left);
            ans.add(u.left.data);
          }
          if (u.right != null) {
            q.add(u.right);
            ans.add(u.right.data);
          }
        }
      }

    }
    return ans;
  }
}

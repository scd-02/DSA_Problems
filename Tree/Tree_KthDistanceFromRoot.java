import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Tree_KthDistanceFromRoot {
  ArrayList<Integer> Kdistance(Node root, int k) {
    Deque<Node> q = new LinkedList<>();
    int level = 0;

    q.add(root);
    boolean flag = false;

    ArrayList<Integer> ans = new ArrayList<>();

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node u = q.poll();
        if (level == k) {
          ans.add(u.data);
          flag = true;
        }
        if (u.left != null)
          q.add(u.left);
        if (u.right != null)
          q.add(u.right);
      }
      level++;
      if (flag)
        break;
    }
    return ans;
  }
}

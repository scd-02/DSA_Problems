import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Tree_reverseLevelOrderTraversal {

  // i/p: 1 2 3 N N 5 6
  // o/p: 5 6 2 3 1
  
  public ArrayList<Integer> reverseLevelOrder(Node node) {
    ArrayList<Integer> ans = new ArrayList<>();

    Deque<Node> q = new LinkedList<>();
    Stack<Integer> s = new Stack<>();

    q.add(node);
    s.push(node.data);

    while (!q.isEmpty()) {
      Node u = q.poll();
      if (u.right != null) {
        q.add(u.right);
        s.push(u.right.data);
      }
      if (u.left != null) {
        q.add(u.left);
        s.push(u.left.data);
      }
    }

    while (!s.empty()) {
      ans.add(s.pop());
    }

    return ans;
  }
}

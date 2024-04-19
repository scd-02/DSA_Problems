import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree_BottomView {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public ArrayList<Integer> bottomView(Node root) {
    Map<Integer, Integer> hm = new TreeMap<>();
    Queue<Pair> q = new LinkedList<>();

    q.add(new Pair(root, 0));
    hm.put(0, root.data);

    while (!q.isEmpty()) {
      Pair p = q.poll();
      Node u = p.node;
      int line = p.line;

      hm.put(line, u.data);

      if (u.left != null) {
        q.add(new Pair(u.left, line - 1));
      }

      if (u.right != null) {
        q.add(new Pair(u.right, line + 1));
      }

    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int val : hm.values()) {

      ans.add(val);
    }

    return ans;

  }

  class Pair {
    Node node;
    int line;

    Pair(Node node, int line) {
      this.node = node;
      this.line = line;
    }
  }
}

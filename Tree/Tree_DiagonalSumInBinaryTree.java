import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * i/p: 10 8 2 3 5 2
 * o/p: 12 15 3
 * concept of vertical and horizontal distance and level order traversal
 */

public class Tree_DiagonalSumInBinaryTree {
  public static ArrayList<Integer> diagonalSum(Node root) {

    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> q = new ArrayDeque<>();

    q.add(new Pair(0, root));

    while (!q.isEmpty()) {
      Pair curr = q.poll();

      if (map.containsKey(curr.v)) {
        map.put(curr.v, map.get(curr.v) + curr.root.data);
      } else {
        map.put(curr.v, curr.root.data);
      }

      if (curr.root.left != null) {
        q.add(new Pair(curr.v + 1, curr.root.left));
      }
      if (curr.root.right != null) {
        q.add(new Pair(curr.v, curr.root.right));
      }

    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      ans.add(e.getValue());
    }

    return ans;
  }

  static class Pair {
    int v;
    Node root;

    Pair(int v, Node root) {
      this.v = v;
      this.root = root;
    }
  }
}
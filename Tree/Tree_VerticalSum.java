import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_VerticalSum {
  class Solution {
    class Node {
      int data;
      Node left, right;

      Node(int item) {
        data = item;
        left = right = null;
      }
    }

    public ArrayList<Integer> verticalSum(Node root) {

      HashMap<Integer, Integer> hm = new HashMap<>();

      // BFS
      Queue<Item> q = new LinkedList<>();
      q.add(new Item(root, 0));

      while (!q.isEmpty()) {

        Item node = q.poll();
        Node u = node.u;
        int line = node.line;

        if (!hm.containsKey(line)) {
          hm.put(line, u.data);
        } else {
          hm.put(line, hm.get(line) + u.data);
        }

        if (u.left != null)
          q.add(new Item(u.left, line - 1));
        if (u.right != null)
          q.add(new Item(u.right, line + 1));

      }

      ArrayList<Integer> temp = new ArrayList<>(hm.keySet());
      Collections.sort(temp);

      ArrayList<Integer> ans = new ArrayList<>();

      for (int ele : temp) {
        ans.add(hm.get(ele));
      }

      return ans;
    }

    class Item {
      Node u;
      int line;

      Item(Node u, int line) {
        this.u = u;
        this.line = line;
      }
    }
  }

}

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int item) {
    data = item;
    left = right = null;
  }

}

public class Rec_SpiralLevelOrderTra {
  static ArrayList<Integer> findSpiral(TreeNode root) {

    ArrayList<Integer> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    Deque<TreeNode> q = new LinkedList<>();
    q.add(root);

    int level = 0;

    ans.add(root.data);

    while (!q.isEmpty()) {
      level++;
      int n = q.size();
      for (int i = 0; i < n; i++) {
        if (level % 2 != 0) {
          TreeNode curr = q.poll();
          if (curr.left != null) {
            q.add(curr.left);
            ans.add(curr.left.data);
          }
          if (curr.right != null) {
            q.add(curr.right);
            ans.add(curr.right.data);
          }
        } else {
          TreeNode curr = q.removeLast();
          if (curr.right != null) {
            q.addFirst(curr.right);
            ans.add(curr.right.data);
          }
          if (curr.left != null) {
            q.addFirst(curr.left);
            ans.add(curr.left.data);
          }
        }
      }
    }

    return ans;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);

    ArrayList<Integer> list = findSpiral(root);

    for (Integer e : list) {
      System.out.print(e + " ");
    }
  }
}
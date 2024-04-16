import java.util.LinkedList;
import java.util.Queue;

public class Tree_AddOneRowToTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public TreeNode addOneRow(TreeNode root, int val, int depth) {

    if (root == null) {
      return root;
    }

    if (depth == 1) {
      return new TreeNode(val, root, null);
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int level = 1;

    while (level != depth) {

      int size = q.size();

      if (level + 1 == depth) {
        for (int i = 0; i < size; i++) {

          TreeNode curr = q.poll();

          TreeNode n1 = new TreeNode(val);
          n1.left = curr.left;
          TreeNode n2 = new TreeNode(val);
          n2.right = curr.right;

          curr.left = n1;
          curr.right = n2;
        }
      } else {
        for (int i = 0; i < size; i++) {

          TreeNode curr = q.poll();
          if (curr.left != null)
            q.offer(curr.left);
          if (curr.right != null)
            q.offer(curr.right);

        }
      }

      level++;
    }

    return root;
  }
}

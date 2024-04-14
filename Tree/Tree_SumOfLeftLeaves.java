import java.util.LinkedList;
import java.util.Queue;

public class Tree_SumOfLeftLeaves {

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

  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeavesDFS(root, false);
  }

  public int sumOfLeftLeavesDFS(TreeNode root, boolean isLeft) {

    if (root == null)
      return 0;

    if (root.left == null && root.right == null) {
      return isLeft ? root.val : 0;
    }

    int left = sumOfLeftLeavesDFS(root.left, true);
    int right = sumOfLeftLeavesDFS(root.right, false);

    return left + right;
  }

  public int sumOfLeftLeavesBFS(TreeNode root) {
    int sum = 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {

      int n = q.size();

      for (int i = 0; i < n; i++) {

        TreeNode node = q.poll();

        if (node.left != null) {
          TreeNode leftChild = node.left;
          if (leftChild.left == null && leftChild.right == null) {
            sum += leftChild.val;
          }
          q.add(leftChild);
        }

        if (node.right != null) {
          q.add(node.right);
        }
      }
    }

    return sum;
  }
}

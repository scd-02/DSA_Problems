public class Tree_SumRootToLeafNumbers {
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

  public int sumNumbers(TreeNode root) {
    int ans[] = new int[1];

    preorder(root, 0, ans);
    return ans[0];
  }

  public void preorder(TreeNode root, int prev, int ans[]) {
    if (root == null)
      return;

    if (root.left == null && root.right == null) {
      prev = prev * 10 + root.val;
      ans[0] += prev;
      return;
    }

    prev = prev * 10 + root.val;
    preorder(root.left, prev, ans);
    preorder(root.right, prev, ans);

  }
}

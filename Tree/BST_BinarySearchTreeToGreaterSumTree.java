/**
 * BST_BinarySearchTreeToGreaterSumTree
 */
public class BST_BinarySearchTreeToGreaterSumTree {
  // Definition for a binary tree node.
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

  public TreeNode bstToGst(TreeNode root) {
    int nodeSum[] = { 0 };
    traversal(root, nodeSum);
    return root;
  }

  public void traversal(TreeNode root, int nodeSum[]) {
    if (root == null)
      return;

    traversal(root.right, nodeSum);

    nodeSum[0] += root.val;
    root.val = nodeSum[0];

    traversal(root.left, nodeSum);
  }
}
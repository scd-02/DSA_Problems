public class BST_SumOfLeafNodesInBST {
  public static int sumOfLeafNodes(Node root) {
    if (root == null)
      return 0;

    if (root.left == null && root.right == null)
      return root.data;

    int left = sumOfLeafNodes(root.left);
    int right = sumOfLeafNodes(root.right);

    return left + right;
  }

  static void solve(Node root, int sum[]) {

    if (root == null)
      return;

    if (root.left == null && root.right == null)
      sum[0] += root.data;

    solve(root.left, sum);
    solve(root.right, sum);
  }
}

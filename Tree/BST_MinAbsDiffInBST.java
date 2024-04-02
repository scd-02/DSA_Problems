public class BST_MinAbsDiffInBST {
  Integer prev = null;
  int ans = Integer.MAX_VALUE;

  int absolute_diff(Node root) {
    inorder(root);
    return ans;
  }

  void inorder(Node root) {

    if (root == null)
      return;

    inorder(root.left);

    if (prev == null) {
      prev = root.data;
    } else {
      ans = Math.min(ans, Math.abs(root.data - prev));
      prev = root.data;
    }

    inorder(root.right);
  }
}

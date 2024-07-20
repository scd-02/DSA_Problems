public class Tree_RemoveHalfNodes {
  public Node RemoveHalfNodes(Node root) {
    if (root == null)
      return null;

    root.left = RemoveHalfNodes(root.left);
    root.right = RemoveHalfNodes(root.right);

    if (root.left != null && root.right == null)
      return root.left;
    if (root.left == null && root.right != null)
      return root.right;

    return root;
  }
}

public class Tree_isSymmetric {
  /*
   * i/p: 1 2 3 4 N N 4
   * o/p: true
   */
  boolean isSymmetric(Node root) {
    if (root == null) {
      return true;
    }

    return isIdentical(root.left, root.right);
  }

  boolean isIdentical(Node root1, Node root2) {
    if (root1 == null || root2 == null) {
      return root1 == root2;
    }
    return (root1.data == root2.data) && isIdentical(root1.left, root2.right)
        && isIdentical(root1.right, root2.left);
  }
}

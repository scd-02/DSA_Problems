public class Tree_CheckBalancedTree {

  /*
   * Given a binary tree, find if it is height balanced or not.
   * A tree is height balanced if difference between heights of left and right
   * subtrees is not more than one for all nodes of tree.
   */
  
  public static boolean isBalanced(Node root) {

    int h = balanced(root);
    if (h > -1) {
      return true;
    }

    return false;
  }

  public static int balanced(Node root) {
    if (root == null) {
      return 0;
    }

    int left = balanced(root.left);
    if (left == -1)
      return -1;

    int right = balanced(root.right);
    if (right == -1)
      return -1;

    if (Math.abs(left - right) > 1)
      return -1;
    return Math.max(left, right) + 1;
  }
}

public class Tree_ChildrenSumParent {
  /*
   * sum of child nodes is equal to root node
   * i/p: 7 2 5 1 1 3 2 N N N N 1 2
   * o/P: true
   */
  public static int isSumProperty(Node root) {
    if (root == null)
      return 1;
    if (root.left == null && root.right == null)
      return 1;

    int left = 0, right = 0;
    if (root.left != null)
      left = root.left.data;
    if (root.right != null)
      right = root.right.data;
    if ((left + right) != root.data)
      return 0;
    return ((isSumProperty(root.left) == 1) && (isSumProperty(root.right) == 1)) ? 1 : 0;
  }
}

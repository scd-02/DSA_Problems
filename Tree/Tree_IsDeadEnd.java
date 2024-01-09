public class Tree_IsDeadEnd {
  /*
   * i/p: 8 5 9 7 2 1
   * o/p: true(there is a deadend)
   */
  public static boolean isDeadEnd(Node root) {
    return solve(root, 1, Integer.MAX_VALUE);
  }

  static boolean solve(Node root, int min, int max) {
    if (root == null)
      return false;
    if (min == max)
      return true;
    return solve(root.left, min, root.data - 1) || solve(root.right, root.data + 1, max);
  }
}

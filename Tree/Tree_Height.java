public class Tree_Height {
  public static int height(Node node) {
    if (node == null) {
      return 0;
    }

    int left = height(node.left);
    int right = height(node.right);

    return Math.max(left, right) + 1;
  }
}

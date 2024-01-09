public class Tree_RootToLeafPathSum2 {
  public class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  public static long treePathsSum(Node root) {

    long total[] = new long[1];

    preorder(root, "", total);

    return total[0];
  }

  public static void preorder(Node root, String s, long total[]) {
    if (root == null)
      return;

    s = s + root.data;

    if (root.left == null && root.right == null) {
      total[0] += Long.parseLong(s);
      return;
    }

    preorder(root.left, s, total);
    preorder(root.right, s, total);
  }
}

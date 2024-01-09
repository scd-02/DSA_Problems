public class Tree_RootToLeafPathSum {
  public class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  boolean hasPathSum(Node root, int s) {
    int sum = 0;
    return solve(root, s, sum);

  }

  boolean solve(Node root, int s, int sum) {
    if (root == null) {
      return false;
    }

    sum += root.data;
    if ((root.left == null && root.right == null) && s == sum) {
      return true;
    }

    return solve(root.left, s, sum) || solve(root.right, s, sum);

  }
}

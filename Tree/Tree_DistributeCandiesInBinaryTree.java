public class Tree_DistributeCandiesInBinaryTree {
  
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static int distributeCandy(Node root) {
    int arr[] = new int[1];

    distribute(root, arr);

    return arr[0];
  }

  public static int distribute(Node root, int arr[]) {

    if (root == null)
      return 0;

    int left = distribute(root.left, arr);
    int right = distribute(root.right, arr);

    arr[0] += Math.abs(left) + Math.abs(right);

    return left + right + root.data - 1;
  }
}

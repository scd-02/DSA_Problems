public class Tree_TransformToSumTree1 {
  public class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  // i/p: 10 -2 6 8 -4 7 5(tree)
  // o/p: 0 4 0 20 0 12 0 (level order traversal output)

  public void toSumTree(Node root) {
    if (root == null)
      return;

    sumTree(root);
  }

  int sumTree(Node root) {
    if (root == null)
      return 0;

    int curr = root.data;
    int left = sumTree(root.left);
    int right = sumTree(root.right);

    root.data = left + right;

    return curr + left + right;

  }
}

public class Tree_MinimumDistanceBWTwoGivenNodes {
  class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  int findDist(Node root, int a, int b) {
    // Your code here
    Node lca = LCA(root, a, b);

    int ha = height(lca, a);
    int hb = height(lca, b);

    return ha + hb;
  }

  Node LCA(Node root, int a, int b) {
    if (root == null || root.data == a || root.data == b) {
      return root;
    }

    Node left = LCA(root.left, a, b);
    Node right = LCA(root.right, a, b);

    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    }

    return root;
  }

  int height(Node root, int n) {
    if (root == null)
      return -1;

    if (root.data == n)
      return 0;

    int left = height(root.left, n);
    int right = height(root.right, n);

    if (left == -1 && right == -1)
      return -1;
    else if (right == -1)
      return left + 1;
    else
      return right + 1;
  }
}

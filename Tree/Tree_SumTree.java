public class Tree_SumTree {
  boolean isSumTree(Node root) {

    return findSum(root) != -1;
  }

  int findSum(Node root) {

    if (root == null)
      return 0;

    if (root.left == null && root.right == null)
      return root.data;

    int left = findSum(root.left);
    int right = findSum(root.right);

    if (root.data != left + right)
      return -1;

    return root.data + left + right;
  }
}

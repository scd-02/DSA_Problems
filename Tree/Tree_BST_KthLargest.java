public class Tree_BST_KthLargest {

  int ans = 0, n = 0;

  public int kthLargest(Node root, int k) {
    reverseInorder(root, k);
    return ans;
  }

  public void reverseInorder(Node root, int k) {
    if (root == null) {
      return;
    }

    reverseInorder(root.right, k);
    n++;
    if (n == k)
      ans = root.data;
    reverseInorder(root.left, k);
  }

  /*
   * Alternatively store the BST in a arraylist by traversing in Inorder because
   * it store the nodes in increasing order and
   * get element at index size-k
   */
}

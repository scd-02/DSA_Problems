import java.util.ArrayList;

public class BST_KthCommonAncestorInBST {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public int kthCommonAncestor(Node root, int k, int x, int y) {

    int lca = lcaBST(root, x, y).data;

    ArrayList<Integer> arr = new ArrayList<>();
    findPath(root, arr, lca);

    return arr.size() - k < 0 ? -1 : arr.get(arr.size() - k);

  }

  public Node lcaBST(Node root, int x, int y) {

    if (root == null)
      return null;

    if (root.data > x && root.data > y) {
      return lcaBST(root.left, x, y);
    }

    if (root.data < x && root.data < y) {
      return lcaBST(root.right, x, y);
    }

    return root;
  }

  public void findPath(Node root, ArrayList<Integer> arr, int x) {

    Node curr = root;

    while (curr.data != x) {
      arr.add(curr.data);

      if (curr.data < x) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }

    }

    arr.add(curr.data);
  }
}

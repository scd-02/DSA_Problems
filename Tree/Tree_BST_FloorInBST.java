public class Tree_BST_FloorInBST {
  public static int floor(Node root, int x) {

    if (root == null)
      return -1;

    if (x < smallest(root))
      return -1;

    Node curr = root;
    int ans = -1;

    while (curr != null) {

      if (curr.data <= x && ans < x) {
        ans = curr.data;
      }

      if (curr.data == x) {
        return x;
      } else if (curr.data < x) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }

    }

    return ans;
  }

  public static int smallest(Node root) {
    Node curr = root;

    while (curr.left != null) {
      curr = curr.left;
    }

    return curr.data;
  }
}

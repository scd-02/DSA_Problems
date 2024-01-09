public class Tree_BST_InorderSuccessor {
  /*
   * i/p: 20 8 22 4 12 N N N N 10 14; x = 8
   * o/p: 10
   */
  public Node inorderSuccessor(Node root, Node x) {
    Node succ = null;
    while (root != null) {
      if (root.data > x.data) {
        succ = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return succ;
  }
}

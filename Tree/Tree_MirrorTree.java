public class Tree_MirrorTree {

  // i/p: 1 2 3 N N 5 6
  // o/p: 1 3 2 5 4 N N

  public static void mirror(Node node) {
    if (node == null) {
      return;
    }

    mirror(node.left);
    mirror(node.right);

    // Swaping of nodes
    Node temp = node.left;
    node.left = node.right;
    node.right = temp;
  }
}

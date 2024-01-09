public class Tree_InsertANodeInBST {

  /*
   * i/p: 2 1 3 N N N 6, key = 4
   * o/p: inorder way: 1 2 3 4 6 (2 1 3 N N N 6 4 N)
   */

  Node insert(Node root, int key) {

    Node newNode = new Node(key);
    Node curr = root;
    Node parent = null;

    while (curr != null) {
      parent = curr;
      if (curr.data < key) {
        curr = curr.right;
      } else if (curr.data > key) {
        curr = curr.left;
      } else {
        break;
      }
    }

    if (parent == null)
      return newNode;

    if (parent.data == key)
      return root;
    else if (parent.data < key)
      parent.right = newNode;
    else
      parent.left = newNode;

    return root;
  }

  Node insertRec(Node root, int key) {
    if (root == null)
      return new Node(key);

    if (root.data == key)
      return root;
    else if (root.data < key)
      root.right = insertRec(root.right, key);
    else
      root.left = insertRec(root.left, key);

    return root;
  }
}

public class DLL_BinaryTreeToDLL {

  class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node prev = null;
  Node head = null;

  // Function to convert binary tree to doubly linked list and return it.
  Node bToDLL(Node root) {
    inorder(root);
    return head;
  }

  void inorder(Node root) {

    if (root == null)
      return;

    inorder(root.left);

    if (prev == null) {
      head = root;
    } else {
      prev.right = root;
      root.left = prev;
    }

    prev = root;

    inorder(root.right);

  }
}

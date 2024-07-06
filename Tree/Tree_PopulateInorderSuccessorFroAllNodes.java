public class Tree_PopulateInorderSuccessorFroAllNodes {
  class Node {
    int data;
    Node left, right, next;

    Node(int item) {
      data = item;
      left = right = next = null;
    }
  }

  Node next = null;

  void populateNext(Node node) {
    if (node != null) {
      populateNext(node.right);
      node.next = next;
      next = node;
      populateNext(node.left);
    }
  }
}

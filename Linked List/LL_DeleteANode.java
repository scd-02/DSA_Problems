public class LL_DeleteANode {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  Node deleteNode(Node head, int x) {

    if (x == 1) {
      head = head.next;
      return head;
    }

    int count = 1;
    Node prev = null;
    Node curr = head;

    while (curr != null && count != x) {

      prev = curr;
      curr = curr.next;
      count++;

    }

    prev.next = curr.next;

    return head;
  }
}

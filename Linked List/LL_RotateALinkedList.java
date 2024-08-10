public class LL_RotateALinkedList {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public Node rotate(Node head, int k) {

    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = head;

    Node temp = head;
    Node prev = null;

    while (k > 0) {
      prev = temp;
      temp = temp.next;
      k--;
    }

    if (prev != null) {
      prev.next = null;
    } else {
      curr.next = null;
    }

    return temp;
  }
}

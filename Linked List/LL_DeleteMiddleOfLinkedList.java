public class LL_DeleteMiddleOfLinkedList {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  Node deleteMid(Node head) {

    if (head == null || head.next == null)
      return null;

    if (head.next.next == null)
      return new Node(head.data);

    Node slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    slow.data = slow.next.data;
    slow.next = slow.next.next;

    return head;
  }
}

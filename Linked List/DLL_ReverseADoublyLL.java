public class DLL_ReverseADoublyLL {
  class Node {
    int data;
    Node next, prev;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public static Node reverseDLL(Node head) {
    Node curr = head;

    while (head.next != null) {

      curr = head.next;
      head.next = head.prev;
      head.prev = curr;
      head = curr;

    }

    head.next = head.prev;
    head.prev = null;
    return head;
  }
}

public class DLL_DeleteNodeInDoubleLinkedList {
  class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
      data = x;
      next = null;
      prev = null;
    }
  }

  public Node deleteNode(Node head, int x) {

    // base case if first node
    if (x == 1) {
      head = head.next;
      head.prev = null;
      return head;
    }

    Node curr = head;

    while (x > 1) {
      curr = curr.next;
      x--;
    }

    Node temp = curr.prev;
    temp.next = curr.next;
    curr.prev = null;

    // if not the last node
    if (temp.next != null) {
      temp.next.prev = temp;
    }

    return head;
  }
}

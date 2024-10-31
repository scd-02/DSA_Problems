public class DLL_InsertInSortedWayInASortedDLL {
  class Node {
    int data;
    Node prev, next;

    Node(int data) {
      this.data = data;
      this.prev = this.next = null;
    }
  }

  public Node sortedInsert(Node head, int val) {
    Node x = new Node(val);

    // base case
    if (head == null) {
      return x;
    }

    // insert at head
    if (val <= head.data) {
      x.next = head;
      head.prev = x;
      return x;
    }

    Node curr = head;
    Node prev = null;

    while (curr != null && val >= curr.data) {
      prev = curr;
      curr = curr.next;
    }

    prev.next = x;
    x.prev = prev;
    x.next = curr;

    if (curr != null) {
      curr.prev = x;
    }

    return head;
  }
}

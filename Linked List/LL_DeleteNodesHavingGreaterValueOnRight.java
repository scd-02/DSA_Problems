public class LL_DeleteNodesHavingGreaterValueOnRight {

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  Node compute(Node head) {

    // remove all the smaller elements and point head to element that is greater
    // than right side
    while (head.next != null && (head.data < head.next.data)) {
      head = head.next;
    }

    if (head.next == null)
      return head;

    Node curr, next;
    curr = head;
    next = head.next;

    while (next != null) {

      if (next.data > curr.data) {

        // element is greater than head
        if (head.data < next.data) {
          head.next = null;
          head = next;
          curr = next;
          next = curr.next;
          continue;
        }

        Node temp = head;
        Node prev = temp;

        // element is greater than first element starting from head(head is not
        // included)
        while (temp != next && temp.data >= next.data) {
          prev = temp;
          temp = temp.next;
        }

        prev.next = next;
        curr.next = null;

      }
      curr = next;
      next = curr.next;

    }

    return head;
  }
}

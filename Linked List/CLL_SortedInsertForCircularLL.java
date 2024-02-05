public class CLL_SortedInsertForCircularLL {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public Node sortedInsert(Node head, int data) {

    if (head == null) {
      Node temp = new Node(data);
      temp.next = temp;
      return temp;
    }

    // head insertion
    if (data < head.data) {

      Node curr = head;
      while (curr.next != head) {
        curr = curr.next;
      }

      curr.next = new Node(data);
      curr = curr.next;
      curr.next = head;

      return curr;
    }

    // anywhere
    Node first = head;
    Node previous = first;
    first = first.next;

    while (first != head) {
      if (first.data >= data) {
        previous.next = new Node(data);
        previous = previous.next;
        previous.next = first;
        return head;
      } else {
        previous = first;
        first = first.next;
      }
    }
    previous.next = new Node(data);
    previous = previous.next;
    previous.next = head;

    return head;
  }
}

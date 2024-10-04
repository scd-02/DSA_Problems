public class CLL_DeletionAndReverseInCircularLinkedList {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node reverse(Node head) {

    if (head == null || head.next == head)
      return head;

    Node curr = head.next;
    Node prev = head;

    while (curr != head) {
      Node temp = curr.next;

      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    curr.next = prev;
    return prev;
  }

  // Function to delete a node from the circular linked list
  Node deleteNode(Node head, int key) {

    if (head.next == head && head.data == key)
      return null;

    Node curr = head;

    if (head.data == key) {
      while (curr.next != head) {
        curr = curr.next;
      }

      head = head.next;
      curr.next = head;
      return head;
    }

    Node prev = head;
    curr = head.next;

    while (curr != head) {
      if (curr.data == key) {
        prev.next = curr.next;
        break;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }

    return head;
  }
}

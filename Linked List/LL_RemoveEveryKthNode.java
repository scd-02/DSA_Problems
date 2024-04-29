public class LL_RemoveEveryKthNode {
  class Node {

    Node next;
    int data;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  Node delete(Node head, int k) {

    if (k == 1)
      return null;

    Node curr = head;
    Node prev = null;

    int count = 1;

    while (curr != null) {

      if (count % k == 0) {
        prev.next = curr.next;
        curr = curr.next;
      } else {
        prev = curr;
        curr = curr.next;
      }

      count++;
    }

    return head;
  }
}

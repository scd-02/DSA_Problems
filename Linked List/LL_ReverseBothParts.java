public class LL_ReverseBothParts {
  class Node {
    int data;
    Node next;

    Node(int x) {
      data = x;
      next = null;
    }
  }

  public static Node reverse(Node head, int k) {

    int count = 1;
    Node prev1 = null, curr = head, next = head;

    while (curr != null && count <= k) {
      next = curr.next;
      curr.next = prev1;
      prev1 = curr;
      curr = next;
      count++;
    }

    Node prev2 = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev2;
      prev2 = curr;
      curr = next;
    }

    head.next = prev2;

    return prev1;
  }
}

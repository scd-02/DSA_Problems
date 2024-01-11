
public class LL_ReverseALL {
  static class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}
  static Node reverse(Node head) {

    Node p = null;
    Node q = head, n = head;

    while (q != null) {
      n = n.next;

      q.next = p;
      p = q;
      q = n;

    }

    return p;
  }
}

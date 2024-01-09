class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class LL_ReverseALL {
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

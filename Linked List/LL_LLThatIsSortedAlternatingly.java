public class LL_LLThatIsSortedAlternatingly {
  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public Node sort(Node head) {

    if (head == null || head.next == null)
      return head;

    if (head.data > head.next.data) {
      head = reverse(head);
    }

    Node last = head;
    while (last.next != null) {
      last = last.next;
    }

    return ascending(head, last);

  }

  public Node ascending(Node head, Node last) {

    Node curr = head;

    while (curr.next != last && curr.next != last.next) {

      Node temp1 = curr.next;
      curr.next = temp1.next;
      curr = curr.next;

      if (last.next == null) {
        last.next = temp1;
        temp1.next = null;
      } else {
        Node temp2 = last.next;
        last.next = temp1;
        temp1.next = temp2;
      }

    }

    return head;
  }

  Node reverse(Node head) {
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

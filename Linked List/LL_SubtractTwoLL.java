public class LL_SubtractTwoLL {
  class Node {
    int data;
    Node next;

    Node(int x) {
      data = x;
      next = null;
    }
  }

  Node removeZero(Node head) {

    if (head == null)
      return null;

    while (head != null && head.data == 0) {
      head = head.next;
    }

    return head;
  }

  int length(Node head) {
    int n = 0;

    Node curr = head;

    while (curr != null) {
      n++;
      curr = curr.next;
    }

    return n;
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

  Node subtract(Node head1, Node head2, int n1, int n2) {

    Node res = new Node(0);

    head1 = reverse(head1);
    head2 = reverse(head2);

    Node curr1 = head1, curr2 = head2, curr3 = res;

    while (curr1 != null || curr2 != null) {

      Node next = curr1.next;

      int a = curr1 != null ? curr1.data : 0;
      int b = curr2 != null ? curr2.data : 0;

      if (a < b) {
        a += 10;
        next.data = next.data - 1;
      }

      curr3.next = new Node(a - b);
      curr1 = curr1.next;
      if (curr2 != null)
        curr2 = curr2.next;
      curr3 = curr3.next;
    }

    res = res.next;
    res = reverse(res);
    res = removeZero(res);

    return res;
  }

  public Node subLinkedList(Node head1, Node head2) {

    if (head1 == null) {
      return head2;
    }

    if (head2 == null) {
      return head1;
    }

    head1 = removeZero(head1);
    head2 = removeZero(head2);

    if (head1 == null && head2 == null) {
      return new Node(0);
    }

    int n1 = length(head1);
    int n2 = length(head2);

    Node ans = null;

    if (n1 < n2) {
      ans = subtract(head2, head1, n2, n1);
    } else if (n1 == n2) {

      Node curr1 = head1;
      Node curr2 = head2;
      boolean flag = false;

      while (curr1 != null) {
        if (curr1.data < curr2.data) {
          ans = subtract(head2, head1, n2, n1);
          flag = true;
          break;
        } else if (curr1.data > curr2.data) {
          ans = subtract(head1, head2, n1, n2);
          flag = true;
          break;
        }

        curr1 = curr1.next;
        curr2 = curr2.next;
      }

      if (flag == false) {
        ans = new Node(0);
      }

    } else {
      ans = subtract(head1, head2, n1, n2);
    }

    return ans;
  }

}

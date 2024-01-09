class LL_Node {
  int data;
  LL_Node next;

  LL_Node(int d) {
    data = d;
    next = null;
  }
}

public class LL_AddingTwoLL {
  static LL_Node addTwoLists(LL_Node first, LL_Node second) {

    first = reverse(first);
    second = reverse(second);

    LL_Node ans = new LL_Node(0);
    LL_Node curr = ans;
    int carry = 0;

    while (first != null || second != null || carry != 0) {

      int digit1 = first == null ? 0 : first.data;
      int digit2 = second == null ? 0 : second.data;

      int sum = digit1 + digit2 + carry;

      curr.next = new LL_Node(sum % 10);
      carry = sum / 10;

      if (first != null)
        first = first.next;
      if (second != null)
        second = second.next;

      curr = curr.next;

    }

    ans = ans.next;
    ans = reverse(ans);

    return ans;

  }

  static LL_Node reverse(LL_Node head) {

    LL_Node p = null;
    LL_Node q = head, n = head;

    while (q != null) {
      n = n.next;

      q.next = p;
      p = q;
      q = n;

    }

    return p;
  }
}

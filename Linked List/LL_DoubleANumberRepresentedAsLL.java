public class LL_DoubleANumberRepresentedAsLL {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode doubleIt(ListNode head) {

    head = reverse(head);

    ListNode curr = head;
    int carry = 0;

    while (curr != null) {

      int sum = (curr.val << 1) + carry;

      curr.val = sum % 10;
      carry = sum / 10;

      curr = curr.next;
    }

    head = reverse(head);
    if (carry != 0) {
      ListNode newNode = new ListNode(carry);
      newNode.next = head;
      head = newNode;
    }

    return head;
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head, next = head;

    while (curr != null) {
      next = curr.next;

      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}

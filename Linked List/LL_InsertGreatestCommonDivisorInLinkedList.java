public class LL_InsertGreatestCommonDivisorInLinkedList {
  class ListNode {
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

  public ListNode insertGreatestCommonDivisors(ListNode head) {

    if (head == null || head.next == null)
      return head;

    ListNode prev = head;
    ListNode curr = head.next;

    while (curr != null) {

      int gcd = gcd(prev.val, curr.val);

      ListNode temp = new ListNode(gcd);
      prev.next = temp;
      temp.next = curr;
      prev = curr;
      curr = curr.next;

    }

    return head;
  }

  int gcd(int a, int b) {
    if (a == 1 || b == 1) {
      return 1;
    }
    while (b != 0) {
      int rem = a % b;
      a = b;
      b = rem;
    }
    return a;
  }
}

public class LL_MergeNodesInBetweenZeros {

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

  public ListNode mergeNodes(ListNode head) {

    ListNode prev = head;
    ListNode curr = head.next;

    while (curr != null) {
      int sum = 0;
      while (curr.val != 0) {
        sum += curr.val;
        curr = curr.next;
      }

      prev.val = sum;

      if (curr.next == null) {
        prev.next = null;
      } else {
        prev.next = curr;
      }

      prev = curr;
      curr = curr.next;

    }

    return head;
  }
}

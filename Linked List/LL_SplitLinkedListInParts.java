public class LL_SplitLinkedListInParts {

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

  public ListNode[] splitListToParts(ListNode head, int k) {

    ListNode[] ans = new ListNode[k];

    int size = 0;
    ListNode curr = head;

    while (curr != null) {
      curr = curr.next;
      size++;
    }

    int splitSize = size / k;
    int remainingParts = size % k;

    curr = head;
    ListNode prev = curr;

    for (int i = 0; i < k; i++) {

      ListNode newPart = curr;

      int currSize = splitSize;
      if (remainingParts > 0) {
        currSize++;
        remainingParts--;
      }

      int j = 0;
      while (j < currSize) {
        prev = curr;
        curr = curr.next;
        j++;
      }

      if (prev != null) {
        prev.next = null;
      }

      ans[i] = newPart;
    }

    return ans;
  }
}

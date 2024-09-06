import java.util.HashSet;

public class LL_DeleteNodesFromLinkedListPresentInArray {

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

  public ListNode modifiedList(int[] nums, ListNode head) {
    HashSet<Integer> hs = new HashSet<>();

    for (int ele : nums) {
      hs.add(ele);
    }

    while (head != null && hs.contains(head.val)) {
      head = head.next;
    }

    if (head == null) {
      return null;
    }

    ListNode curr = head;
    while (curr.next != null) {

      if (hs.contains(curr.next.val)) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }

    }

    return head;
  }
}
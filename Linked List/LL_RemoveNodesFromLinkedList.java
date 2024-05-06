import java.util.Stack;

public class LL_RemoveNodesFromLinkedList {
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

  class Solution1 {
    public ListNode removeNodes(ListNode head) {

      Stack<ListNode> stk = new Stack<>();

      ListNode curr = head;

      while (curr != null) {
        stk.push(curr);
        curr = curr.next;
      }

      curr = stk.pop();
      int max = curr.val;

      ListNode ans = new ListNode(max);

      while (!stk.isEmpty()) {

        curr = stk.pop();

        if (curr.val < max) {
          continue;
        } else {
          ListNode newNode = new ListNode(curr.val);
          newNode.next = ans;
          ans = newNode;
          max = curr.val;
        }

      }

      return ans;
    }
  }

  class Solution2 {
    public ListNode removeNodes(ListNode head) {

      ListNode reversed = reverse(head);
      ListNode prev = reversed;

      int max = reversed.val;
      ListNode curr = reversed.next;

      while (curr != null) {
        if (curr.val < max) {
          prev.next = curr.next;
          curr.next = null;
        } else {
          max = curr.val;
          prev = curr;
        }

        curr = prev.next;
      }

      return reverse(reversed);

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

  class Solution3 {
    public ListNode removeNodes(ListNode head) {
      if (head.next == null) {
        return head;
      }
      ListNode prevNode = head;
      ListNode currentNode = head.next;

      while (currentNode != null) {
        ListNode nextNode = currentNode.next;
        currentNode.next = prevNode;
        prevNode = currentNode;
        currentNode = nextNode;
      }
      head.next = null;
      head = prevNode;

      prevNode = head;
      currentNode = head.next;
      while (currentNode != null) {
        if (currentNode.val < prevNode.val) {
          currentNode = currentNode.next;
        } else {
          ListNode nextNode = currentNode.next;
          currentNode.next = prevNode;
          prevNode = currentNode;
          currentNode = nextNode;
        }

      }
      head.next = null;
      head = prevNode;
      return head;
    }
  }
}

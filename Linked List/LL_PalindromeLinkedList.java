public class LL_PalindromeLinkedList {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  boolean isPalindrome(Node head) {

    Node slow = head, fast = head, prev = null;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;

      Node temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }

    if (fast != null) {
      slow = slow.next;
    }

    while (slow != null) {
      if (prev.data != slow.data)
        return false;

      prev = prev.next;
      slow = slow.next;
    }

    return true;
  }
}

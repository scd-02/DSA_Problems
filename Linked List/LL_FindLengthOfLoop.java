public class LL_FindLengthOfLoop {

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public int countNodesinLoop(Node head) {

    if (head == null || head.next == null)
      return 0;

    Node slow = head, fast = head;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast)
        break;
    }

    if (slow != fast)
      return 0;

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    int count = 1;

    while (slow.next != fast) {
      slow = slow.next;
      count++;
    }

    return count;
  }
}

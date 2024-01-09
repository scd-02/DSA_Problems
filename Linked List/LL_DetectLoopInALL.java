public class LL_DetectLoopInALL {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static boolean detectLoop(Node head) {

    if (head == null) {
      return true;
    }

    Node fast = head;
    Node slow = head;

    while (fast.next != null && fast.next.next != null) {

      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow)
        return true;

    }

    return false;
  }
}

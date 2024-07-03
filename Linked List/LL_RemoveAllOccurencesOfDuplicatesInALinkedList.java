public class LL_RemoveAllOccurencesOfDuplicatesInALinkedList {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public Node removeAllDuplicates(Node head) {

    if (head == null || head.next == null)
      return head;

    Node temp = new Node(-1);
    temp.next = head;

    Node prev2 = temp;
    Node prev1 = head;
    Node curr = head.next;

    boolean flag = false;
    while (curr != null) {

      while (curr != null && curr.data == prev1.data) {
        prev1 = curr;
        curr = curr.next;
        flag = true;
      }

      if (curr == null)
        break;

      if (flag) {
        prev1.next = null;
        prev2.next = curr;
        flag = false;

      } else {
        prev2 = prev1;
      }

      prev1 = curr;
      curr = curr.next;

    }

    if (flag) {
      prev1.next = null;
      prev2.next = curr;
    }

    return temp.next;
  }
}

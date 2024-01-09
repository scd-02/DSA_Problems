import java.util.HashSet;

public class LL_RemoveDuplicatesFromAnUnsortedLL {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public Node removeDuplicates(Node head) {
    if (head == null || head.next == null)
      return head;

    HashSet<Integer> hs = new HashSet<>();

    Node curr = head;
    Node prev = null;

    while (curr != null) {

      if (hs.contains(curr.data)) {
        prev.next = curr.next;
        curr = curr.next;
      } else {
        hs.add(curr.data);
        prev = curr;
        curr = curr.next;
      }

    }

    return head;
  }
}

public class LL_PairwiseSwapElementsOfALL {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

  public Node pairwiseSwap(Node head) {
    if (head == null || head.next == null)
      return head;

    Node even = head.next;
    Node odd = head;

    Node root = even;

    while (true) {

      if (even.next == null || even.next.next == null) {

        // if length is 2 or 3 from odd pointer
        odd.next = even.next;
        even.next = odd;
        break;

      } else {

        // Swap
        odd.next = even.next.next;
        Node temp = even.next;
        even.next = odd;

        // update the odd and even node
        even = odd.next;
        odd = temp;

      }
    }

    return root;
  }
}

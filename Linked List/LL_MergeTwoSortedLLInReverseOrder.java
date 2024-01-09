public class LL_MergeTwoSortedLLInReverseOrder {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  Node mergeResult(Node node1, Node node2) {
    node1 = reverse(node1);
    node2 = reverse(node2);

    Node temp1 = node1;
    Node temp2 = node2;

    Node ans = new Node(0);
    Node curr = ans;

    while (temp1 != null && temp2 != null) {

      if (temp1.data < temp2.data) {
        curr.next = new Node(temp2.data);
        temp2 = temp2.next;
      } else {
        curr.next = new Node(temp1.data);
        temp1 = temp1.next;
      }

      curr = curr.next;
    }

    while (temp1 != null) {
      curr.next = new Node(temp1.data);
      curr = curr.next;
      temp1 = temp1.next;
    }

    while (temp2 != null) {
      curr.next = new Node(temp2.data);
      curr = curr.next;
      temp2 = temp2.next;
    }

    ans = ans.next;
    return ans;
  }

  Node reverse(Node head) {

    if (head == null || head.next == null)
      return head;

    Node prev = null, curr = head, next = head;

    while (curr != null) {

      next = next.next;

      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}

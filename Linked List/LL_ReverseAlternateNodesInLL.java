public class LL_ReverseAlternateNodesInLL {

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

  public static void rearrange(Node odd) {
    // edge case
    if (odd.next == null || odd.next.next == null)
      return;

    Node last_node = odd;
    int n = 0;

    while (last_node.next != null) {
      last_node = last_node.next;
      n++;
    }

    Node add_From_Last = null;

    Node curr = odd.next;
    Node prev = odd;

    int count = 0;
    while (count != n / 2) {

      // Deletion
      prev.next = curr.next;
      prev = curr.next;
      curr.next = null;

      // Insertion from last
      if (add_From_Last == null) {
        last_node.next = curr;
        add_From_Last = curr;
      } else {
        last_node.next = curr;
        curr.next = add_From_Last;
        add_From_Last = curr;
      }

      curr = prev.next;

      count++;
    }

  }
}

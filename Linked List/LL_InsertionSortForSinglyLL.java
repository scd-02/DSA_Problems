public class LL_InsertionSortForSinglyLL {
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static Node insertionSort(Node head_ref) {
    Node curr = head_ref.next;
    Node prev = head_ref;

    while (curr != null) {

      if (curr.data >= prev.data) {
        prev = curr;
        curr = curr.next;
      } else {

        int data = curr.data;
        prev.next = curr.next;
        curr = curr.next;

        Node newNode = new Node(data);
        if (data <= head_ref.data) {
          newNode.next = head_ref;
          head_ref = newNode;
        } else {

          Node start = head_ref;

          while (start != prev && data > start.next.data) {
            start = start.next;
          }

          newNode.next = start.next;
          start.next = newNode;
        }
      }

    }

    return head_ref;
  }
}

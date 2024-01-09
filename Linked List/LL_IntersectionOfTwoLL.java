public class LL_IntersectionOfTwoLL {
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static Node findIntersection(Node head1, Node head2) {
    Node curr1 = head1;
    Node curr2 = head2;

    Node head = null;
    Node curr3 = null;

    while (curr1 != null && curr2 != null) {

      if (curr1.data == curr2.data) {

        Node newNode = new Node(curr1.data);

        if (head == null) {
          head = newNode;
          curr3 = newNode;
        } else {
          curr3.next = newNode;
          curr3 = curr3.next;
        }

        curr1 = curr1.next;
        curr2 = curr2.next;

      } else if (curr1.data > curr2.data) {
        curr2 = curr2.next;
      } else {
        curr1 = curr1.next;
      }

    }

    return head;
  }
}

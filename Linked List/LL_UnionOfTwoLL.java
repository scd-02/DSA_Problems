import java.util.Set;
import java.util.TreeSet;

public class LL_UnionOfTwoLL {
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static Node findUnion(Node head1, Node head2) {
    Node curr1 = head1;
    Node curr2 = head2;

    Set<Integer> ts = new TreeSet<>();

    while (curr1 != null) {
      ts.add(curr1.data);
      curr1 = curr1.next;
    }

    while (curr2 != null) {
      ts.add(curr2.data);
      curr2 = curr2.next;
    }

    Node res = new Node(0);
    Node curr = res;

    for (Integer i : ts) {
      Node temp = new Node(i);
      curr.next = temp;
      curr = curr.next;
    }

    res = res.next;
    return res;
  }
}

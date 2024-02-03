public class LL_DecimalEquOfBinaryLL {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  long DecimalValue(Node head) {
    long mod = 1000_000_000 + 7;

    Node curr = head;
    long ans = 0;

    while (curr != null) {

      ans = ((ans << 1) | curr.data) % mod;
      curr = curr.next;
    }

    return ans;
  }
}

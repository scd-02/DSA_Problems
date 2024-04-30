public class LL_AddingTwoLL {
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  static Node addTwoLists(Node num1, Node num2) {

    num1 = reverse(num1);
    num2 = reverse(num2);

    Node ans = new Node(0);
    Node curr = ans;
    int carry = 0;

    while (num1 != null || num2 != null || carry != 0) {
      int a = num1 == null ? 0 : num1.data;
      int b = num2 == null ? 0 : num2.data;

      int sum = a + b + carry;

      curr.next = new Node(sum % 10);
      carry = sum / 10;

      if (num1 != null)
        num1 = num1.next;
      if (num2 != null)
        num2 = num2.next;

      curr = curr.next;
    }

    ans = ans.next;
    ans = reverse(ans);

    while (ans != null && ans.data == 0) {
      ans = ans.next;
    }

    return ans == null ? new Node(0) : ans;
  }

  static Node reverse(Node head) {
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

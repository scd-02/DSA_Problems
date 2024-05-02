import java.util.HashSet;

public class LL_ArrangeConsonantsAndVowels {
  class Node {
    char data;
    Node next;

    public Node(char data) {
      this.data = data;
      next = null;
    }
  }

  public Node arrangeCV(Node head) {

    Node vowels = new Node(' '), conso = new Node(' ');

    Node v = vowels, c = conso, curr = head;

    while (curr != null) {
      if (curr.data == 'a' || curr.data == 'e' ||
          curr.data == 'i' || curr.data == 'o' ||
          curr.data == 'u') {
        v.next = curr;
        v = v.next;
      } else {
        c.next = curr;
        c = c.next;
      }

      curr = curr.next;
    }

    c.next = null;
    v.next = conso.next;

    return vowels.next;

  }

  public Node arrangeCV2(Node head) {

    HashSet<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');

    Node v = new Node(' ');
    v.next = head;
    Node ans = v;

    Node curr = head;

    // initial values are vowels
    while (curr != null && vowels.contains(curr.data)) {
      v = curr;
      curr = curr.next;
    }

    Node prev = v;

    while (curr != null) {

      if (vowels.contains(curr.data)) {
        prev.next = curr.next;

        curr.next = v.next;
        v.next = curr;
        v = v.next;

        curr = prev.next;
      } else {
        prev = curr;
        curr = curr.next;
      }

    }

    ans = ans.next;
    return ans;
  }
}

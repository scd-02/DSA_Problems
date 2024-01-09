public class LL_FlatteningALinkedList {
  class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
      data = d;
      next = null;
      bottom = null;
    }
  }

  class GfG {
    Node flatten(Node root) {
      Node curr1 = root;
      Node curr2 = root.next;

      while (curr2 != null) {
        curr1 = merge(curr1, curr2);
        curr2 = curr2.next;
      }

      return curr1;
    }

    void display(Node root) {

      Node curr = root;
      while (curr != null) {
        System.out.print(curr.data + " ");
        curr = curr.bottom;
      }
      System.out.println();
    }

    Node merge(Node root1, Node root2) {

      Node i = root1, j = root2;
      Node head = null;

      if (i.data < j.data) {
        head = new Node(i.data);
        i = i.bottom;
      } else {
        head = new Node(j.data);
        j = j.bottom;
      }

      Node temp = head;

      while (i != null && j != null) {
        if (i.data < j.data) {
          temp.bottom = new Node(i.data);
          temp = temp.bottom;
          i = i.bottom;
        } else {
          temp.bottom = new Node(j.data);
          temp = temp.bottom;
          j = j.bottom;
        }
      }

      while (i != null) {
        temp.bottom = new Node(i.data);
        temp = temp.bottom;
        i = i.bottom;
      }

      while (j != null) {
        temp.bottom = new Node(j.data);
        temp = temp.bottom;
        j = j.bottom;
      }

      return head;
    }
  }
}
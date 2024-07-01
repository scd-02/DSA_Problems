import java.util.LinkedList;
import java.util.Queue;

public class LL_MakeBinaryTreeFromLinkedList {
  static class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
      data = d;
      left = null;
      right = null;
    }
  }

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static Tree convert(Node head, Tree node) {

    if (head == null)
      return node;

    node = new Tree(head.data);
    head = head.next;

    Queue<Tree> q = new LinkedList<>();
    q.add(node);

    while (head != null && head.next != null) {

      Tree root = q.poll();

      root.left = new Tree(head.data);
      q.add(root.left);
      head = head.next;

      root.right = new Tree(head.data);
      q.add(root.right);
      head = head.next;

    }

    if (head != null) {
      Tree root = q.poll();
      root.left = new Tree(head.data);
    }

    return node;
  }
}

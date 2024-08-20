import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_BurningTree {

  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  public static int minTime(Node root, int target) {

    HashMap<Node, Node> parentTrack = new HashMap<>();
    preorder(root, null, parentTrack);

    Node targetNode = findTarget(root, target);

    Queue<Node> q = new LinkedList<>();
    q.add(targetNode);

    HashSet<Node> visited = new HashSet<>();
    visited.add(targetNode);

    int level = 0;

    while (!q.isEmpty()) {

      int size = q.size();

      for (int i = 0; i < size; i++) {

        Node currNode = q.poll();
        Node parent = parentTrack.get(currNode);
        Node left = currNode.left, right = currNode.right;

        if (parent != null && !visited.contains(parent)) {
          q.add(parent);
          visited.add(parent);
        }

        if (left != null && !visited.contains(left)) {
          q.add(left);
          visited.add(left);
        }

        if (right != null && !visited.contains(right)) {
          q.add(right);
          visited.add(right);
        }

      }

      level++;
    }

    return level - 1;
  }

  private static Node findTarget(Node root, int target) {

    if (root == null || root.data == target)
      return root;

    Node left = findTarget(root.left, target);
    Node right = findTarget(root.right, target);

    if (left != null)
      return left;

    return right;
  }

  private static void preorder(Node root, Node parent, HashMap<Node, Node> hm) {

    if (root == null)
      return;

    hm.put(root, parent);

    preorder(root.left, root, hm);
    preorder(root.right, root, hm);

  }
}
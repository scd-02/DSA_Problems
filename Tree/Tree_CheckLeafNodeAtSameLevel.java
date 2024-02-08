import java.util.LinkedList;
import java.util.Queue;
public class Tree_CheckLeafNodeAtSameLevel {

  /*
   * By Preorder traversal checking if leaf nodes are at same level or not
   */
  int leafLevel = -1;

  boolean check(Node root) {
    return checkLeaf(root, 0);
  }

  boolean checkLeaf(Node root, int level) {
    if (root == null)
      return true;

    if (root.left == null && root.right == null) {
      if (leafLevel == -1) {
        leafLevel = level;
      }

      return leafLevel == level;
    }

    return checkLeaf(root.left, level + 1) && checkLeaf(root.right, level + 1);
  }

  boolean checkBFS(Node root) {
    if (root == null)
      return true;

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {

      int size = q.size();
      boolean leafPresent = false;
      boolean isLeaf = true;

      for (int i = 0; i < size; i++) {
        Node u = q.poll();

        if (u.left != null) {
          q.add(u.left);
          isLeaf = false;
        }

        if (u.right != null) {
          q.add(u.right);
          isLeaf = false;
        }

        if (!leafPresent && !isLeaf) {
          isLeaf = true;
          continue;
        } else if (!leafPresent && isLeaf && i == 0) {
          leafPresent = true;
          continue;
        } else if (leafPresent && isLeaf) {
          isLeaf = true;
          continue;
        } else if ((!leafPresent && isLeaf) || (leafPresent && !isLeaf)) {
          return false;
        }

      }

    }

    return true;
  }
}

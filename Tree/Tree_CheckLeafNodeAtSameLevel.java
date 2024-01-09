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
}

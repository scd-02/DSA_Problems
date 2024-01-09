public class Tree_CheckIdentical {
  /*
   * Check if two trees are identical
   * i/p : tree1 = 1 2 3 4 N N 4, tree2 = 1 2 3 4 N N 4
   * o/p : true;
   */

  // inorder approach:
  class Solution {

    boolean ans = true;

    boolean isIdentical(Node root1, Node root2) {
      inorder(root1, root2);
      return ans;
    }

    void inorder(Node root1, Node root2) {
      if ((root1 == null && root2 != null) || root1 != null && root2 == null) {
        ans = false;
        return;
      }
      if (root1 != null && root2 != null) {
        inorder(root1.left, root2.left);
        if (root1.data != root2.data) {
          ans = false;
          return;
        }
        inorder(root1.right, root2.right);
      }
    }

    // recursion

    boolean isIdentical2(Node root1, Node root2) {
      if (root1 == null || root2 == null) {
        return root1 == root2;
      }
      return (root1.data == root2.data) && isIdentical2(root1.left, root2.left)
          && isIdentical2(root1.right, root2.right);
    }
  }
}

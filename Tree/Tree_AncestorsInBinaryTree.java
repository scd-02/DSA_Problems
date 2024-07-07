import java.util.ArrayList;

/**
 * This class represents a binary tree and provides a method to find the ancestors of a given target node in the tree.
 */
public class Tree_AncestorsInBinaryTree {

  /**
   * Finds the ancestors of a given target node in the binary tree.
   *
   * @param root   The root node of the binary tree.
   * @param target The value of the target node.
   * @return An ArrayList containing the ancestors of the target node in the binary tree.
   */
  public ArrayList<Integer> Ancestors(Node root, int target) {

    ArrayList<Integer> ans = new ArrayList<>();
    findAncestors(root, target, ans);
    return ans;

  }

  /**
   * Recursive helper method to find the ancestors of a given target node in the binary tree.
   *
   * @param root   The current node being traversed.
   * @param target The value of the target node.
   * @param ans    The ArrayList to store the ancestors of the target node.
   * @return True if the target node is found, false otherwise.
   */
  boolean findAncestors(Node root, int target, ArrayList<Integer> ans) {

    if (root == null)
      return false;

    if (root.data == target)
      return true;

    if (findAncestors(root.left, target, ans)) {
      ans.add(root.data);
      return true;
    }

    if (findAncestors(root.right, target, ans)) {
      ans.add(root.data);
      return true;
    }

    return false;

  }
}
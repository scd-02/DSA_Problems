import java.util.ArrayList;

public class Tree_AncestorsInBinaryTree {
  /*
   * i/p: 1 2 3 4 5 6 8 7; target = 6
   * o/p: 3 1
   */
  public static ArrayList<Integer> Ancestors(Node root, int target) {
    ArrayList<Integer> list = new ArrayList<>();
    solve(list, root, target);
    return list;
  }

  static int solve(ArrayList<Integer> list, Node root, int target) {
    if (root == null)
      return -1;
    if (root.data == target)
      return 0;

    if (solve(list, root.left, target) == 0) {
      list.add(root.data);
      return 0;
    }

    if (solve(list, root.right, target) == 0) {
      list.add(root.data);
      return 0;
    }

    return -1;

  }
}
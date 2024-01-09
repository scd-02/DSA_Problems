import java.util.ArrayList;

public class Tree_BrotherFromDifferentRoots {

  /*
   * i/p: BST1 = 5 3 7 2 4 6 8 ; BST2 = 10 6 15 3 8 11 18 ; value = 16
   * o/p: 3 pairs
   */

  public static int countPairs(Node root1, Node root2, int x) {
    ArrayList<Integer> bst1 = new ArrayList<>();
    ArrayList<Integer> bst2 = new ArrayList<>();
    inorder(bst1, root1);
    inorder(bst2, root2);

    int count = 0;
    int i = 0, j = bst2.size() - 1;
    while (i < bst1.size() && j >= 0) {
      if ((bst1.get(i) + bst2.get(j)) == x) {
        count++;
        i++;
        j--;
      } else if ((bst1.get(i) + bst2.get(j)) < x) {
        i++;
      } else {
        j--;
      }
    }
    return count;
  }

  static void inorder(ArrayList<Integer> list, Node root) {
    if (root == null)
      return;
    inorder(list, root.left);
    list.add(root.data);
    inorder(list, root.right);
  }
}

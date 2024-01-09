public class Tree_LowestCommonAncestor {
  /*
   * Given either both n1 and n2 are present or both are not present;
   * case1: curr = n1 || curr = n2
   * case2: n1 is in left subtree and n2 is in right subtree
   * case3: n1 and n2 both are in same subtree
   * case4: n1 and n2 both are not present
   */

  // i/p: 1 2 3 N N 5 6 , 5, 6
  // o/p: 4

  // i/p: 1 2 3 N N 5 6 , 3, 6
  // o/p: 1

  // i/p: 1 2 3 N N 5 6 , 2, 3
  // o/p: 2

  public static Node LCA(Node root, int n1, int n2) {
    if (root == null) {
      return null;
    }

    if (root.data == n1 || root.data == n2)
      return root;

    Node left = LCA(root.left, n1, n2);
    Node right = LCA(root.right, n1, n2);

    if (left == null)
      return right;
    if (right == null)
      return left;

    return root;
  }
}

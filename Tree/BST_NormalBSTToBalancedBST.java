import java.util.ArrayList;

/*
 * i/p: 4 3 2 1 
 * o/P: 2 1 3 4 
 */

public class BST_NormalBSTToBalancedBST {

  Node buildBalancedTree(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    inorder(root, list);

    return inorderToBalancedBST(0, list.size() - 1, list);

  }

  void inorder(Node root, ArrayList<Integer> list) {
    if (root == null) {
      return;
    }
    inorder(root.left, list);
    list.add(root.data);
    inorder(root.right, list);
  }

  Node inorderToBalancedBST(int s, int e, ArrayList<Integer> list) {
    if (s > e) {
      return null;
    }

    int mid = (s + e) / 2;

    Node root = new Node(list.get(mid));
    root.left = inorderToBalancedBST(s, mid - 1, list);
    root.right = inorderToBalancedBST(mid + 1, e, list);
    return root;
  }
}

public class BST_FlattenBSTToSortedList {
  Node ans = new Node(0);
  Node head = ans;

  public Node flattenBST(Node root) {

    inorder(root);

    ans = ans.right;
    return ans;
  }

  void inorder(Node root) {

    if (root == null)
      return;

    inorder(root.left);

    Node temp = new Node(root.data);
    head.right = temp;
    head = head.right;

    inorder(root.right);
  }

  public Node flattenBST2(Node root) {

    Node ans = new Node(0);

    modifiedInorder(root, ans);

    ans = ans.right;

    return ans;
  }

  Node modifiedInorder(Node root, Node temp) {

    if (root == null)
      return temp;

    Node left = root.left;
    Node right = root.right;

    root.left = root.right = null;

    modifiedInorder(left, temp).right = root;

    return modifiedInorder(right, root);
  }
}

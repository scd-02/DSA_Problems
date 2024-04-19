public class Tree_DiameterOfBinaryTree {
  int diameter(Node root) {
    int ans[] = new int[1];

    height(root, ans);

    return ans[0] + 1;
  }

  int height(Node root, int ans[]) {

    if (root == null)
      return 0;

    int lh = height(root.left, ans);
    int rh = height(root.right, ans);

    ans[0] = Math.max(ans[0], lh + rh);

    return 1 + Math.max(lh, rh);
  }

}
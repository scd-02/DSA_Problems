public class Tree_MinDepthOfABinaryTree {
  int minDep = Integer.MAX_VALUE;

  int minDepth(Node root) {
    dfs(root, 1);
    return minDep;
  }

  void dfs(Node root, int depth) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      minDep = Math.min(minDep, depth);
      return;
    }

    dfs(root.left, depth + 1);
    dfs(root.right, depth + 1);
  }
}

public class Tree_MaximumPathSumFromAnyNode {

  class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  int findMaxSum(Node node) {
    int ans[] = { Integer.MIN_VALUE };
    pathSum(node, ans);
    return ans[0];
  }

  int pathSum(Node root, int ans[]) {
    if (root == null)
      return 0;

    int leftSum = Math.max(0, pathSum(root.left, ans));
    int rightSum = Math.max(0, pathSum(root.right, ans));

    ans[0] = Math.max(ans[0], leftSum + rightSum + root.data);

    return Math.max(leftSum, rightSum) + root.data;
  }
}

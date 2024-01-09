public class Tree_SumOfTheLongestBloodLineOfATree {

  int maxLength = 0;
  int maxSum = Integer.MIN_VALUE;

  void maxSum(Node root, int l, int s) {
    if (root == null) {

      if (l > maxLength) {
        maxLength = l;
        maxSum = s;
      } else if (l == maxLength) {
        maxSum = Math.max(s, maxSum);
      }
      return;
    }

    s = s + root.data;
    maxSum(root.left, l + 1, s);
    maxSum(root.right, l + 1, s);
  }

  public int sumOfLongRootToLeafPath(Node root) {
    maxSum(root, 0, 0);
    return maxSum;
  }

}
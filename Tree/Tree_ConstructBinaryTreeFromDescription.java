public class Tree_ConstructBinaryTreeFromDescription {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode() {}
   * TreeNode(int val) { this.val = val; }
   * TreeNode(int val, TreeNode left, TreeNode right) {
   * this.val = val;
   * this.left = left;
   * this.right = right;
   * }
   * }
   */
  class Solution {
    public TreeNode createBinaryTree(final int[][] descriptions) {
      TreeNode[] nodeMap = new TreeNode[100001];
      boolean[] children = new boolean[100001];

      for (int[] description : descriptions) {
        if (nodeMap[description[0]] == null)
          nodeMap[description[0]] = new TreeNode(description[0]);

        if (nodeMap[description[1]] == null)
          nodeMap[description[1]] = new TreeNode(description[1]);

        if (description[2] == 1)
          nodeMap[description[0]].left = nodeMap[description[1]];
        else
          nodeMap[description[0]].right = nodeMap[description[1]];

        children[description[1]] = true;
      }

      for (int[] description : descriptions)
        if (!children[description[0]])
          return nodeMap[description[0]];

      return null;
    }
  }
}

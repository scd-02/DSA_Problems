import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_DeleteNodesAndReturnForest {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class SolutionDFS {
    boolean[] deleteSet = new boolean[1001];
    List<TreeNode> forest = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      for (int ele : to_delete) {
        deleteSet[ele] = true;
      }

      if (dfs(root) != null) {
        forest.add(root);
      }

      return forest;
    }

    TreeNode dfs(TreeNode root) {
      if (root == null)
        return null;

      root.left = dfs(root.left);
      root.right = dfs(root.right);

      if (!deleteSet[root.val]) {
        return root;
      }

      if (root.left != null) {
        forest.add(root.left);
      }

      if (root.right != null) {
        forest.add(root.right);
      }

      return null;
    }
  }

  class SolutionBFS {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

      HashSet<Integer> deleteSet = new HashSet<>();
      for (int ele : to_delete) {
        deleteSet.add(ele);
      }

      List<TreeNode> forest = new ArrayList<>();

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);

      while (!q.isEmpty()) {
        TreeNode currNode = q.poll();

        if (currNode.left != null) {
          q.add(currNode.left);

          // if left node is needed to be deleted then remove the connection from currNode
          if (deleteSet.contains(currNode.left.val)) {
            currNode.left = null;
          }
        }

        if (currNode.right != null) {
          q.add(currNode.right);

          // if right node is needed to be deleted then remove the connection from
          // currNode
          if (deleteSet.contains(currNode.right.val)) {
            currNode.right = null;
          }
        }

        // if currNode is needed to be deleted
        if (deleteSet.contains(currNode.val)) {
          if (currNode.left != null)
            forest.add(currNode.left);
          if (currNode.right != null)
            forest.add(currNode.right);
        }
      }

      if (!deleteSet.contains(root.val))
        forest.add(root);

      return forest;
    }
  }
}

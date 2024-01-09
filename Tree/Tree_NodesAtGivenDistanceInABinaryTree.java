import java.util.ArrayList;
import java.util.Collections;

public class Tree_NodesAtGivenDistanceInABinaryTree {
  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
    ArrayList<Integer> ans = new ArrayList<>();

    ancestorToTargetPath(root, target, k, ans);
    Collections.sort(ans);

    return ans;
  }

  static int ancestorToTargetPath(Node root, int target, int k, ArrayList<Integer> ans) {

    if (root == null)
      return -1;

    if (root.data == target) {
      dfs(root, k, ans);
      return 0;
    }

    int left = ancestorToTargetPath(root.left, target, k, ans);

    if (left != -1) {

      if (left + 1 == k)
        ans.add(root.data);
      else
        dfs(root.right, k - left - 2, ans);

      return left + 1;

    }

    int right = ancestorToTargetPath(root.right, target, k, ans);

    if (right != -1) {

      if (right + 1 == k)
        ans.add(root.data);
      else
        dfs(root.left, k - right - 2, ans);

      return right + 1;
    }

    return -1;

  }

  static void dfs(Node root, int k, ArrayList<Integer> ans) {

    if (root == null || k < 0)
      return;

    if (k == 0) {
      ans.add(root.data);
      return;
    }

    dfs(root.left, k - 1, ans);
    dfs(root.right, k - 1, ans);

  }
}

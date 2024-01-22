import java.util.ArrayList;

public class Tree_PathsFromRootWithASpecifiedSum {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    ArrayList<Integer> temp = new ArrayList<>();
    preorder(root, sum, 0, ans, temp);

    return ans;
  }

  public static void preorder(Node root, int sum, int currSum,
      ArrayList<ArrayList<Integer>> ans,
      ArrayList<Integer> temp) {

    if (root == null)
      return;

    currSum += root.data;
    temp.add(root.data);

    if (currSum == sum) {
      ans.add(new ArrayList<>(temp));
    }

    preorder(root.left, sum, currSum, ans, temp);
    preorder(root.right, sum, currSum, ans, temp);

    temp.remove(temp.size() - 1);
  }
}

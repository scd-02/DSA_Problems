import java.util.ArrayList;

public class BST_PrintBSTElementsInGivenRange {
  public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {

    ArrayList<Integer> ans = new ArrayList<>();
    inorder(root, low, high, ans);
    return ans;
  }

  static void inorder(Node root, int low, int high, ArrayList<Integer> ans) {

    if (root == null)
      return;

    if (root.data >= low && root.data <= high) {
      inorder(root.left, low, root.data, ans);
      ans.add(root.data);
      inorder(root.right, root.data, high, ans);
    } else if (root.data < low) {
      inorder(root.right, low, high, ans);
    } else {
      inorder(root.left, low, high, ans);
    }

  }
}

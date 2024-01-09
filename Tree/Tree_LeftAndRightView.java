import java.util.ArrayList;
import java.util.HashSet;

public class Tree_LeftAndRightView {
  public static ArrayList<Integer> leftView(Node root) {
    ArrayList<Integer> ans = new ArrayList<>();
    HashSet<Integer> hs = new HashSet<>();

    traversingLV(ans, hs, root, 0);

    return ans;

  }

  public static void traversingLV(ArrayList<Integer> ls, HashSet<Integer> hs, Node root, int level) {
    if (root == null) {
      return;
    }
    if (!hs.contains(level)) {
      hs.add(level);
      ls.add(root.data);
    }

    traversingLV(ls, hs, root.left, level + 1);
    traversingLV(ls, hs, root.right, level + 1);
  }

  public static ArrayList<Integer> rightView(Node root) {
    ArrayList<Integer> ans = new ArrayList<>();
    HashSet<Integer> hs = new HashSet<>();

    traversingRV(ans, hs, root, 0);

    return ans;

  }

  public static void traversingRV(ArrayList<Integer> ls, HashSet<Integer> hs, Node root, int level) {
    if (root == null) {
      return;
    }
    if (!hs.contains(level)) {
      hs.add(level);
      ls.add(root.data);
    }

    traversingRV(ls, hs, root.right, level + 1);
    traversingRV(ls, hs, root.left, level + 1);
  }

  public static void main(String[] args) {
    // creating tree

    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(null);
    a.add(null);
    a.add(6);
    a.add(5);
    Node root = Tree.createBinaryTree(a, 0);

    ArrayList<Integer> ans = leftView(root);
    System.out.println(ans);
    ArrayList<Integer> ans1 = rightView(root);
    System.out.println(ans1);
  }
}

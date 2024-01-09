import java.util.ArrayList;

public class Tree {

  public static Node createBinaryTree(ArrayList<Integer> a, int i) {
    Node root = null;

    if (i >= a.size() || a.get(i) == null) {
      return null;
    }

    root = new Node(a.get(i));

    root.left = createBinaryTree(a, 2 * i + 1);
    root.right = createBinaryTree(a, 2 * i + 2);

    return root;
  }

}
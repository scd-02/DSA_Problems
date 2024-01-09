import java.util.ArrayList;

public class Tree_TransformToSumTree2 {
  public class Node {
    int data;
    Node left, right;
  
    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }
  
  public void toSumTree(Node root) {
    ArrayList<Node> path = new ArrayList<>();
    preorder(root, path);

  }

  public void preorder(Node root, ArrayList<Node> path) {

    if (root == null)
      return;

    int value = root.data;

    for (int i = path.size() - 1; i >= 0; i--) {
      path.get(i).data += value;
    }

    root.data -= value;

    path.add(root);

    preorder(root.left, path);
    preorder(root.right, path);

    path.remove(path.size() - 1);
  }
}

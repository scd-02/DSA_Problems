import java.util.ArrayList;

public class Tree_SerializeAndDeserializeABinaryTree {
  class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  static int i;

  public void preorder(Node root, ArrayList<Integer> a) {
    if (root == null) {
      a.add(-1);
      return;
    }

    a.add(root.data);
    preorder(root.left, a);
    preorder(root.right, a);
  }

  public ArrayList<Integer> serialize(Node root) {
    ArrayList<Integer> a = new ArrayList<>();
    preorder(root, a);
    return a;
  }

  // Function to deserialize a list and construct the tree.
  public Node deSerialize(ArrayList<Integer> A) {
    i = -1;
    Node root = create(A);
    return root;
  }

  public Node create(ArrayList<Integer> a) {
    i++;

    if (a.get(i) == -1) {
      return null;
    }

    Node root = new Node(a.get(i));

    root.left = create(a);
    root.right = create(a);

    return root;
  }
}

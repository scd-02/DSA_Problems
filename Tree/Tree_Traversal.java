import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Tree_Traversal {

  public static void inOrder(Node root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static void preOrder(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void postOrder(Node root) {
    if (root == null) {
      return;
    }

    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
  }

  public static ArrayList<Integer> levelOrder(Node node) {
    ArrayList<Integer> ans = new ArrayList<>();
    Deque<Node> q = new LinkedList<Node>();

    q.add(node);
    while (!q.isEmpty()) {
      Node u = q.poll();
      ans.add(u.data);
      if (u.left != null)
        q.add(u.left);
      if (u.right != null)
        q.add(u.right);
    }

    return ans;
  }

  public static void main(String[] args) {

    ArrayList<Integer> a = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array: ");
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      Integer val = sc.nextInt();
      if (val == -1) {
        a.add(null);
      } else {
        a.add(val);
      }
    }

    Node root = Tree.createBinaryTree(a, 0);

    System.out.print("InOrder: ");
    inOrder(root);
    System.out.println();
    System.out.print("PreOrder: ");
    preOrder(root);
    System.out.println();
    System.out.print("PostOrder: ");
    postOrder(root);

    sc.close();
  }
}

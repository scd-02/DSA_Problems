public class Tree_MedianOfBST {

  static int size = 0;
  static int count = 0;

  public static float findMedian(Node root) {
    inorder(root);

    int k = (size >> 1) + 1;
    int mid = getMid(root, k);
    System.out.println(mid);
    if ((size & 1) == 1) {
      return (float) mid;
    } else {
      count = 0;
      int prev = getMid(root, k - 1);
      System.out.println(prev);
      return (mid + prev) / (float) 2;
    }

  }

  static void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    size++;
    inorder(root.right);
  }

  static int getMid(Node root, int k) {
    if (root == null) {
      return -1;
    }
    int left = getMid(root.left, k);
    count++;
    if (count == k) {
      return root.data;
    }
    int right = getMid(root.right, k);
    if (left != -1)
      return left;
    if (right != -1)
      return right;
    return -1;
  }

  public static void main(String[] args) {
    // Node root = new Node(6);
    // root.left = new Node(3);
    // root.right = new Node(8);
    // root.left.left = new Node(2);
    // root.left.right = new Node(4);
    // root.right.left = new Node(7);
    // root.right.right = new Node(9);
    // root.left.left.left = new Node(1);
    Node root = new Node( 4);
    root.left = new Node(2);
    System.out.println(findMedian(root));
    System.out.println(size);
    System.out.println(count);
    

  }
}

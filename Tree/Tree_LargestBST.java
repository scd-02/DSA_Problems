public class Tree_LargestBST {
  static int largestBst(Node root) {

    return largestBST(root).size;
  }

  static NodeInfo largestBST(Node root) {

    if (root == null)
      return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

    NodeInfo left = largestBST(root.left);
    NodeInfo right = largestBST(root.right);

    NodeInfo curr = new NodeInfo();

    curr.min = Math.min(left.min, root.data);
    curr.max = Math.max(right.max, root.data);
    curr.isBst = left.isBst && right.isBst && (root.data > left.max && root.data < right.min);

    if (curr.isBst) {
      curr.size = 1 + left.size + right.size;
    } else {
      curr.size = Math.max(left.size, right.size);
      ;
    }

    return curr;
  }

  static class NodeInfo {

    int size, min, max;
    boolean isBst;

    NodeInfo() {
    }

    NodeInfo(int size, int min, int max, boolean isBst) {
      this.size = size;
      this.min = min;
      this.max = max;
      this.isBst = isBst;
    }

  }
}

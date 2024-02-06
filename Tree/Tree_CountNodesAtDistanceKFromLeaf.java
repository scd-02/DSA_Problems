public class Tree_CountNodesAtDistanceKFromLeaf {
  class Node {
    int data;
    Node left, right;

    public Node(int d) {
      data = d;
      left = right = null;
    }
  }

  int printKDistantfromLeaf(Node root, int k) {
    int considered[] = new int[100000];

    int count[] = new int[1];

    countNodes(root, k, 0, count, considered);
    return count[0];
  }

  void countNodes(Node root, int k, int pathLen, int count[], int considered[]) {

    if (root == null)
      return;

    considered[pathLen] = 0;

    pathLen++;

    int depth = pathLen - k - 1;
    if (root.left == null && root.right == null
        && depth >= 0
        && considered[depth] == 0) {

      considered[depth] = 1;
      count[0]++;
      return;
    }

    countNodes(root.left, k, pathLen, count, considered);
    countNodes(root.right, k, pathLen, count, considered);
  }
}

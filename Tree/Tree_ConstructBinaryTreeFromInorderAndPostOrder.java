public class Tree_ConstructBinaryTreeFromInorderAndPostOrder {
  int postIndex;

  Node buildTree(int in[], int post[], int n) {

    postIndex = n - 1;
    return createTree(in, post, 0, n - 1);

  }

  Node createTree(int in[], int post[], int s, int e) {

    if (s > e)
      return null;

    Node root = new Node(post[postIndex--]);

    int index = findRoot(in, s, e, root.data);

    root.right = createTree(in, post, index + 1, e);
    root.left = createTree(in, post, s, index - 1);

    return root;
  }

  int findRoot(int in[], int s, int e, int data) {

    int index = s;
    for (int i = s; i <= e; i++) {
      if (in[i] == data) {
        index = i;
        break;
      }
    }

    return index;
  }
}

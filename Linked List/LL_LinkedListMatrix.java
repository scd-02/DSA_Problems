public class LL_LinkedListMatrix {
  static Node construct(int arr[][]) {

    int n = arr.length, m = arr[0].length;

    Node mat[][] = new Node[n][m];

    for (int i = 0; i < n; i++) {
      mat[i][0] = new Node(arr[i][0]);
      Node curr = mat[i][0];
      for (int j = 1; j < m; j++) {
        mat[i][j] = new Node(arr[i][j]);
        curr.right = mat[i][j];
        curr = curr.right;
      }
    }

    for (int j = 0; j < m; j++) {
      Node curr = mat[0][j];
      for (int i = 1; i < n; i++) {
        curr.down = mat[i][j];
        curr = curr.down;
      }
    }

    return mat[0][0];
  }
}

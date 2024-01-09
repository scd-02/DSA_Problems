public class Matrix_AntiDiagonalTraversalOfMatrix {
  public int[] antiDiagonalPattern(int[][] matrix) {
    int n = matrix.length;

    int totalEle = n * n;
    int ans[] = new int[totalEle];
    int k = 0;

    int r = 0, c = 0;

    while (totalEle-- >= 0) {

      int row = r, col = c;

      while (row >= 0 && row < n && col >= 0 && col < n) {

        ans[k] = matrix[row][col];
        row++;
        col--;
        k++;
      }

      if (c < n - 1) {
        c++;
      } else {
        r++;
      }
    }

    return ans;
  }
}

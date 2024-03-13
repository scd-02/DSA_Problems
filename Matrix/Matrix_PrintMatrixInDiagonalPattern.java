public class Matrix_PrintMatrixInDiagonalPattern {
  public int[] matrixDiagonally(int[][] mat) {

    int n = mat.length;
    int ans[] = new int[n * n];

    boolean down = false;
    int i = 0, j = 0;

    for (int k = 0; k < n * n;) {

      if (down) {

        for (; j >= 0 && i < n; j--, i++) {
          ans[k] = mat[i][j];
          k++;
        }

        if (j < 0 && i < n) {
          j = 0;
        }

        if (i == n) {
          j += 2;
          i--;
        }
      } else {

        for (; i >= 0 && j < n; i--, j++) {
          ans[k] = mat[i][j];
          k++;
        }

        if (i < 0 && j < n) {
          i = 0;
        }

        if (j == n) {
          i += 2;
          j--;
        }

      }

      down = !down;
    }

    return ans;
  }
}

public class Matrix_SurroundThe1s {
  public int Count(int[][] matrix) {

    int n = matrix.length;
    int m = matrix[0].length;

    int ans = 0;

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {

        int count = 0;

        if (matrix[row][col] == 1) {

          count = countIn8Dir(matrix, row, col, n, m);

          if (count != 0 && count % 2 == 0)
            ans++;
        }
      }
    }

    return ans;
  }

  public static int countIn8Dir(int[][] matrix, int row, int col, int n, int m) {

    int dr[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
    int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

    int count = 0;

    int rowS = 0;
    int colS = 0;

    for (int k = 0; k < 8; k++) {

      rowS = row + dr[k];
      colS = col + dc[k];

      if (rowS < n && colS < m && rowS >= 0 && colS >= 0 && matrix[rowS][colS] == 0) {
        count++;
      }
    }

    return count;
  }
}
public class Matrix_LargestSubsquareSurroundedByX {

  int largestSubsquare(int n, char a[][]) {

    int row[][] = new int[n][n];
    int col[][] = new int[n][n];

    prefixSum(row, col, n, a);

    int max = 0;

    // traversing from bottom because row[i][j] tells that till that col in row
    // matrix, it is continuous
    // x and col[i][j] tells that till that row in col matrix, it is continuous x

    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {

        int size = Math.min(row[i][j], col[i][j]);

        // to check whether the other side of the square i.e. top side and left side of
        // square is having the continuous x >= size if yes then it is new max or else
        // try it
        // with size - 1
        while (size > max) {

          if (row[i - size + 1][j] >= size && col[i][j - size + 1] >= size) {
            max = size;
            break;
          } else {
            size--;
          }

        }

      }
    }

    return max;
  }

  void prefixSum(int row[][], int col[][], int n, char a[][]) {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        row[i][j] = a[i][j] == 'X' ? (j == 0 ? 1 : row[i][j - 1] + 1) : 0;
        col[j][i] = a[j][i] == 'X' ? (j == 0 ? 1 : col[j - 1][i] + 1) : 0;

      }
    }
  }
}
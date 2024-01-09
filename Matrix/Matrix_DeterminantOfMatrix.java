public class Matrix_DeterminantOfMatrix {
  static int determinantOfMatrix(int matrix[][], int n) {
    if (n == 1) {
      return matrix[0][0];
    }

    if (n == 2) {
      return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    int determinant = 0;

    for (int j = 0; j < n; j++) {

      int cofactor = (int) Math.pow(-1, (0 + j)) * matrix[0][j] * determinantOfMatrix(submatrix(matrix, 0, j), n - 1);
      determinant += cofactor;

    }

    return determinant;
  }

  static int[][] submatrix(int matrix[][], int r, int c) {

    int n = matrix.length;
    int submatrix[][] = new int[n - 1][n - 1];

    // for traversal in submatrix
    int row = 0, col = 0;

    // for traversal in matrix
    for (int i = 0; i < n; i++) {

      if (i == r) {
        continue;
      }

      for (int j = 0; j < n; j++) {
        if (j == c) {
          continue;
        }

        submatrix[row][col] = matrix[i][j];
        col++;
      }

      col = 0;
      row++;
    }

    return submatrix;
  }
}

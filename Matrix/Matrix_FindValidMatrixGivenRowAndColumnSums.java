public class Matrix_FindValidMatrixGivenRowAndColumnSums {

  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int N = rowSum.length;
    int M = colSum.length;

    int[] currRowSum = new int[N];
    int[] currColSum = new int[M];

    int[][] origMatrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        origMatrix[i][j] = Math.min(
            rowSum[i] - currRowSum[i],
            colSum[j] - currColSum[j]);

        currRowSum[i] += origMatrix[i][j];
        currColSum[j] += origMatrix[i][j];
      }
    }
    return origMatrix;
  }

  public int[][] restoreMatrixSpaceOptim(int[] rowSum, int[] colSum) {

    int n = rowSum.length;
    int m = colSum.length;

    int[][] originalMatrix = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        originalMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

        rowSum[i] -= originalMatrix[i][j];
        colSum[j] -= originalMatrix[i][j];

      }
    }

    return originalMatrix;
  }

  public int[][] restoreMatrixTimeAndSpaceOptim(int[] rowSum, int[] colSum) {

    int n = rowSum.length;
    int m = colSum.length;

    int[][] originalMatrix = new int[n][m];

    int i = 0, j = 0;

    while (i < n && j < m) {
      originalMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

      rowSum[i] -= originalMatrix[i][j];
      colSum[j] -= originalMatrix[i][j];

      if (rowSum[i] == 0)
        i++;
      else
        j++;
    }

    return originalMatrix;
  }
}

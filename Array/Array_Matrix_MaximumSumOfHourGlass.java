public class Array_Matrix_MaximumSumOfHourGlass {
  int findMaxSum(int n, int m, int mat[][]) {

    int max = -1;

    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < m - 2; j++) {
        int sum = 0;

        sum += mat[i][j] + mat[i][j + 1] + mat[i][j + 2];
        sum += mat[i + 1][j + 1];
        sum += mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];

        max = Math.max(sum, max);
      }
    }

    return max;
  }
}

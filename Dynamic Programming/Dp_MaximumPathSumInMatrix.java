import java.util.Arrays;

public class Dp_MaximumPathSumInMatrix {
  static int maximumPath(int N, int Matrix[][]) {
    int ans = (int) Math.pow(-10, 9);

    int dp[][] = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int j = 0; j < N; j++) {
      // ans = Math.max(ans, rec(0, j, N, Matrix));
      ans = Math.max(ans, mem(0, j, N, Matrix, dp));
    }

    return tab(Matrix, N);
  }

  static int rec(int i, int j, int n, int matrix[][]) {

    if (j < 0 || j >= n)
      return (int) Math.pow(-10, 9);

    if (i == n - 1)
      return matrix[i][j];

    int d = matrix[i][j] + rec(i + 1, j, n, matrix);
    int ld = matrix[i][j] + rec(i + 1, j - 1, n, matrix);
    int rd = matrix[i][j] + rec(i + 1, j + 1, n, matrix);

    return Math.max(d, Math.max(ld, rd));
  }

  static int mem(int i, int j, int n, int matrix[][], int dp[][]) {

    if (j < 0 || j >= n)
      return (int) Math.pow(-10, 9);

    if (i == n - 1)
      return matrix[i][j];

    if (dp[i][j] != -1)
      return -1;

    int d = matrix[i][j] + mem(i + 1, j, n, matrix, dp);
    int ld = matrix[i][j] + mem(i + 1, j - 1, n, matrix, dp);
    int rd = matrix[i][j] + mem(i + 1, j + 1, n, matrix, dp);

    return dp[i][j] = Math.max(d, Math.max(ld, rd));
  }

  static int tab(int matrix[][], int n) {

    int dp[][] = new int[n][n];

    for (int j = 0; j < n; j++) {
      dp[0][j] = matrix[0][j];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {

        int d = matrix[i][j] + dp[i - 1][j];

        int ld = (int) Math.pow(-10, 9);
        if (j - 1 >= 0)
          ld = matrix[i][j] + dp[i - 1][j - 1];

        int rd = (int) Math.pow(-10, 9);
        if (j + 1 < n)
          rd = matrix[i][j] + dp[i - 1][j + 1];

        dp[i][j] = Math.max(d, Math.max(ld, rd));
      }
    }

    int ans = (int) Math.pow(-10, 9);

    for (int j = 0; j < n; j++) {
      ans = Math.max(ans, dp[n - 1][j]);
    }

    return ans;
  }
}

public class DAC_UsingDP_SequenceOfSequence {
  static int numberSequence(int m, int n) {

    // return totalRec(m, n);

    // int dp[][] = new int[m + 1][n + 1];
    // Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
    // return totalMem(m, n, dp);

    return totalTab(m, n);
  }

  static int totalTab(int m, int n) {

    int dp[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {

        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (i < j) {
          dp[i][j] = 0;
        } else if (j == 1) {
          dp[i][j] = i;
        } else {
          dp[i][j] = dp[i / 2][j - 1] + dp[i - 1][j];
        }

      }
    }

    return dp[m][n];
  }

  static int totalMem(int m, int n, int dp[][]) {

    if (m < n)
      return 0;

    if (n == 0)
      return 1;

    if (dp[m][n] != -1)
      return dp[m][n];

    int inc = totalMem(m / 2, n - 1, dp);
    int exc = totalMem(m - 1, n, dp);

    dp[m][n] = inc + exc;

    return dp[m][n];

  }

  static int totalRec(int m, int n) {

    if (m < n)
      return 0;

    if (n == 0)
      return 1;

    int inc = totalRec(m / 2, n - 1);
    int exc = totalRec(m - 1, n);

    return inc + exc;

  }
}

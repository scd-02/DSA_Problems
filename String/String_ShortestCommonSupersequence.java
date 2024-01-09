public class String_ShortestCommonSupersequence {
  public static int shortestCommonSupersequence(String X, String Y, int m, int n) {

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {

        if (i == 0 || j == 0) {
          dp[i][j] = 0;
          continue;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }

      }
    }

    return m + n - dp[m][n];
  }
}

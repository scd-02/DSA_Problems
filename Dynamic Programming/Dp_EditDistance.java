public class Dp_EditDistance {
  public int editDistance(String s, String t) {

    int n = s.length();
    int m = t.length();

    int dp[][] = new int[n + 1][m + 1];
    dp[0][0] = 0;

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = dp[0][i - 1] + 1;
    }

    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = dp[i - 1][0] + 1;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }

      }
    }

    return dp[n][m];
  }
}

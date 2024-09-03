public class Dp_MinimumNumberOfInsertionsAndDeletions {
  public int minOperations(String str1, String str2) {

    // int n = str1.length(), m = str2.length();
    // int dp[][] = new int[n + 1][m + 1];
    // for(int i = 0; i <= n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(str1, str2, n, m, dp);

    return tab(str1, str2);
  }

  public int mem(String s, String t, int i, int j, int dp[][]) {

    if (i == 0 && j == 0)
      return 0;

    if (i == 0 && j > 0)
      return j;

    if (i > 0 && j == 0)
      return i;

    if (dp[i][j] != -1)
      return dp[i][j];

    if (s.charAt(i - 1) != t.charAt(j - 1)) {
      int insert = 1 + mem(s, t, i, j - 1, dp);
      int delete = 1 + mem(s, t, i - 1, j, dp);

      dp[i][j] = Math.min(insert, delete);
    } else {
      dp[i][j] = mem(s, t, i - 1, j - 1, dp);
    }

    return dp[i][j];
  }

  public int tab(String s, String t) {
    int n = s.length(), m = t.length();
    int dp[][] = new int[n + 1][m + 1];

    for (int j = 1; j <= m; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= n; i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (s.charAt(i - 1) != t.charAt(j - 1)) {
          int insert = 1 + dp[i][j - 1];
          int delete = 1 + dp[i - 1][j];
          dp[i][j] = Math.min(insert, delete);
        } else {
          dp[i][j] = dp[i - 1][j - 1];
        }
      }
    }

    return dp[n][m];
  }
}

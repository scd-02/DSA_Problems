public class Dp_LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {

    int n = text1.length();
    int m = text2.length();

    // int dp[][] = new int[n + 1][m + 1];
    // for(int i = 0; i < dp.length; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(text1, n, text2, m, dp);

    // return tab(text1, n, text2, m);
    return so(text1, n, text2, m);
  }

  int so(String text1, int n, String text2, int m) {
    int prev[] = new int[m + 1];

    // base case handled as initialization of array is 0;

    for (int i = 1; i <= n; i++) {
      int curr[] = new int[m + 1];
      for (int j = 1; j <= m; j++) {

        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          curr[j] = 1 + prev[j - 1];
        else
          curr[j] = 0 + Math.max(prev[j], curr[j - 1]);
      }
      prev = curr;
    }

    return prev[m];
  }

  int tab(String text1, int n, String text2, int m) {
    int dp[][] = new int[n + 1][m + 1];

    // base case handled as initialization of array is 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (text1.charAt(i - 1) == text2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[n][m];
  }

  int mem(String text1, int i, String text2, int j, int dp[][]) {

    if (i == 0 || j == 0)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    if (text1.charAt(i - 1) == text2.charAt(j - 1))
      return dp[i][j] = 1 + mem(text1, i - 1, text2, j - 1, dp);

    return dp[i][j] = 0 + Math.max(mem(text1, i - 1, text2, j, dp), mem(text1, i, text2, j - 1, dp));
  }
}

public class Dp_StringSubsequence {
  static int mod = 1_000_000_000 + 7;

  public static int countWays(String s1, String s2) {
    int n1 = s1.length(), n2 = s2.length();

    // int dp[][] = new int[n1 + 1][n2 + 1];
    // for(int i = 0; i <= n1; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(s1, s2, n1, n2, dp);

    return tab(s1, s2, n1, n2);
  }

  static int mem(String s1, String s2, int i, int j, int dp[][]) {

    if (j == 0)
      return 1;
    if (i == 0)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    int not_take = mem(s1, s2, i - 1, j, dp);

    int take = 0;

    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      take = mem(s1, s2, i - 1, j - 1, dp);
    }

    return dp[i][j] = (take % mod + not_take % mod) % mod;
  }

  static int tab(String s1, String s2, int n1, int n2) {

    int dp[][] = new int[n1 + 1][n2 + 1];

    for (int i = 0; i <= n1; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        int not_take = dp[i - 1][j];

        int take = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          take = dp[i - 1][j - 1];
        }

        dp[i][j] = (take % mod + not_take % mod) % mod;
      }
    }

    return dp[n1][n2];
  }
}

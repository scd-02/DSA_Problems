public class Dp_PathsToReachOrigin {
  static int mod = 1_000_000_000 + 7;

  public static int ways(int n, int m) {
    // return rec(0, 0, n + 1, m + 1);

    // int dp[][] = new int[n + 1][m + 1];
    // for(int i = 0; i <= n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, 0, n + 1, m + 1, dp);

    return tab(n, m);
  }

  public static int rec(int i, int j, int n, int m) {

    if (i >= n || j >= m)
      return 0;

    if (i == n - 1 && j == m - 1)
      return 1;

    int right = rec(i, j + 1, n, m);
    int down = rec(i + 1, j, n, m);

    return (right + down) % mod;
  }

  public static int mem(int i, int j, int n, int m, int dp[][]) {

    if (i >= n || j >= m)
      return 0;

    if (i == n - 1 && j == m - 1)
      return 1;

    if (dp[i][j] != -1)
      return dp[i][j];

    int right = mem(i, j + 1, n, m, dp);
    int down = mem(i + 1, j, n, m, dp);

    return dp[i][j] = (right + down) % mod;
  }

  public static int tab(int n, int m) {
    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++)
      dp[i][m] = 1;

    for (int j = 0; j <= m; j++)
      dp[n][j] = 1;

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {

        int right = dp[i][j + 1];
        int down = dp[i + 1][j];

        dp[i][j] = (right + down) % mod;
      }
    }

    return dp[0][0];
  }
}

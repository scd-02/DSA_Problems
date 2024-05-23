public class Dp_kPalindrome {
  public int kPalindrome(String str, int n, int k) {

    StringBuilder rev = new StringBuilder(str);
    rev = rev.reverse();

    // int opr = rec(str, rev.toString(), n, n);

    // int dp[][] = new int[n + 1][n + 1];
    // for(int i = 0; i <= n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // int opr = mem(str, rev.toString(), n, n, dp);

    // int opr = tab(str, rev.toString(), n, n);
    // return opr <= 2 * k ? 1 : 0;

    int opr = lcs(str, rev.toString(), n, n);
    return n - opr <= k ? 1 : 0;
  }

  public int rec(String s, String t, int n, int m) {

    if (n == 0) {
      return m;
    }

    if (m == 0) {
      return n;
    }

    if (s.charAt(n - 1) == t.charAt(m - 1)) {
      return rec(s, t, n - 1, m - 1);
    }

    return 1 + Math.min(rec(s, t, n - 1, m), rec(s, t, n, m - 1));
  }

  public int mem(String s, String t, int n, int m, int dp[][]) {

    if (n == 0) {
      return m;
    }

    if (m == 0) {
      return n;
    }

    if (dp[n][m] != -1)
      return dp[n][m];

    if (s.charAt(n - 1) == t.charAt(m - 1)) {
      return dp[n][m] = mem(s, t, n - 1, m - 1, dp);
    }

    return dp[n][m] = 1 + Math.min(mem(s, t, n - 1, m, dp), mem(s, t, n, m - 1, dp));
  }

  public int tab(String s, String t, int n, int m) {

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {

        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }

      }
    }

    return dp[n][m];
  }

  public int lcs(String s, String t, int n, int m) {

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (s.charAt(i - 1) == t.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
      }
    }

    return dp[n][m];
  }
}

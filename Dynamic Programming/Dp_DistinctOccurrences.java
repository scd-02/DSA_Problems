public class Dp_DistinctOccurrences {
  int mod = 1_000_000_000 + 7;

  int subsequenceCount(String s, String t) {
    // return rec(0, 0, s, t);

    // int dp[][] = new int[s.length()][t.length()];

    // for(int i = 0; i < s.length(); i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, 0, s, t, dp);

    return tab(s, t);
  }

  int rec(int i, int j, String s, String t) {

    if (j < t.length() && i >= s.length())
      return 0;

    if (j >= t.length())
      return 1;

    int take = 0;
    if (t.charAt(j) == s.charAt(i)) {
      take = rec(i + 1, j + 1, s, t);
    }

    int not_take = rec(i + 1, j, s, t);

    return (take % mod + not_take % mod) % mod;
  }

  int mem(int i, int j, String s, String t, int dp[][]) {

    if (j < t.length() && i >= s.length())
      return 0;

    if (j >= t.length())
      return 1;

    if (dp[i][j] != -1)
      return dp[i][j];

    int take = 0;
    if (t.charAt(j) == s.charAt(i)) {
      take = mem(i + 1, j + 1, s, t, dp);
    }

    int not_take = mem(i + 1, j, s, t, dp);

    return dp[i][j] = (take % mod + not_take % mod) % mod;

  }

  int tab(String s, String t) {
    int n = s.length(), m = t.length();

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][m] = 1;
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {

        int take = 0;
        if (t.charAt(j) == s.charAt(i)) {
          take = dp[i + 1][j + 1];
        }

        int not_take = dp[i + 1][j];

        dp[i][j] = (take % mod + not_take % mod) % mod;
      }
    }

    return dp[0][0];
  }
}

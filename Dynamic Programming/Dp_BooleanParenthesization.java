import java.util.Arrays;

public class Dp_BooleanParenthesization {
  static int mod = 1003;

  static int countWays(int n, String s) {
    // return rec(0, n - 1, 1, s);

    int dp[][][] = new int[n][n][2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    return mem(0, n - 1, 1, s, dp);
  }

  static int rec(int i, int j, int isTrue, String s) {

    if (i > j)
      return 0;

    if (i == j) {

      if (isTrue == 1)
        return s.charAt(i) == 'T' ? 1 : 0;
      else
        return s.charAt(i) == 'F' ? 1 : 0;

    }

    int ways = 0;

    for (int index = i + 1; index <= j - 1; index += 2) {

      int lt = rec(i, index - 1, 1, s);
      int lf = rec(i, index - 1, 0, s);
      int rt = rec(index + 1, j, 1, s);
      int rf = rec(index + 1, j, 0, s);

      if (s.charAt(index) == '&') {

        if (isTrue == 1) {
          ways = (ways + (lt * rt) % mod) % mod;
        } else {
          ways = (ways + (lt * rf) % mod + (lf * rt) % mod + (lf * rf) % mod) % mod;
        }

      } else if (s.charAt(index) == '|') {

        if (isTrue == 1) {
          ways = (ways + (lt * rt) % mod + (lf * rt) % mod + (lt * rf) % mod) % mod;
        } else {
          ways = (ways + (lf * rf) % mod) % mod;
        }

      } else if (s.charAt(index) == '^') {

        if (isTrue == 1) {
          ways = (ways + (lf * rt) % mod + (lt * rf) % mod) % mod;
        } else {
          ways = (ways + (lt * rt) % mod + (lf * rf) % mod) % mod;
        }

      }
    }

    return ways;
  }

  static int mem(int i, int j, int isTrue, String s, int dp[][][]) {

    if (i > j)
      return 0;

    if (i == j) {

      if (isTrue == 1)
        return s.charAt(i) == 'T' ? 1 : 0;
      else
        return s.charAt(i) == 'F' ? 1 : 0;

    }

    if (dp[i][j][isTrue] != -1)
      return dp[i][j][isTrue];

    int ways = 0;

    for (int index = i + 1; index <= j - 1; index += 2) {

      int lt = mem(i, index - 1, 1, s, dp);
      int lf = mem(i, index - 1, 0, s, dp);
      int rt = mem(index + 1, j, 1, s, dp);
      int rf = mem(index + 1, j, 0, s, dp);

      if (s.charAt(index) == '&') {

        if (isTrue == 1) {
          ways = (ways + (lt * rt) % mod) % mod;
        } else {
          ways = (ways + (lt * rf) % mod + (lf * rt) % mod + (lf * rf) % mod) % mod;
        }

      } else if (s.charAt(index) == '|') {

        if (isTrue == 1) {
          ways = (ways + (lt * rt) % mod + (lf * rt) % mod + (lt * rf) % mod) % mod;
        } else {
          ways = (ways + (lf * rf) % mod) % mod;
        }

      } else if (s.charAt(index) == '^') {

        if (isTrue == 1) {
          ways = (ways + (lf * rt) % mod + (lt * rf) % mod) % mod;
        } else {
          ways = (ways + (lt * rt) % mod + (lf * rf) % mod) % mod;
        }

      }
    }

    return dp[i][j][isTrue] = ways;
  }
}

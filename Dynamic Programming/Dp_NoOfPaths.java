public class Dp_NoOfPaths {
  long mod = 1_000_000_000 + 7;

  long numberOfPathsOptimezed(int m, int n) {

    long mod = 1_000_000_007L;

    long ans = 1;

    for (long i = n; i <= n + m - 2; i++) {

      ans = (ans * i) % mod;
      long invert = invert(i - n + 1, mod);
      ans = (ans * invert) % mod;

    }

    return ans;
  }

  long pow(long x, long y, long mod) {
    long res = 1;

    while (y > 0) {
      if (y % 2 != 0) {
        res = (res * x) % mod;
      }

      y = y >> 1;
      x = (x * x) % mod;
    }

    return res;
  }

  long invert(long i, long mod) {
    return pow(i, mod - 2, mod);
  }

  long numberOfPaths(int M, int N) {

    // return rec(M - 1, N - 1);

    // long dp[][] = new long[M][N];
    // for(int i = 0; i < M; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(M - 1, N - 1, dp);

    return tab(M, N);
  }

  long rec(int i, int j) {

    if (i == 0 && j == 0)
      return 1;

    if (i < 0 || j < 0)
      return 0;

    long up = rec(i - 1, j);
    long left = rec(i, j - 1);

    return (up % mod + left % mod) % mod;
  }

  long mem(int i, int j, long dp[][]) {

    if (i == 0 && j == 0)
      return 1;

    if (i < 0 || j < 0)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    long up = mem(i - 1, j, dp);
    long left = mem(i, j - 1, dp);

    return dp[i][j] = (up % mod + left % mod) % mod;

  }

  long tab(int m, int n) {

    long dp[][] = new long[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (i == 0 && j == 0)
          dp[i][j] = 1;
        else {
          long up = 0, left = 0;

          if (i > 0)
            up = dp[i - 1][j];
          if (j > 0)
            left = dp[i][j - 1];

          dp[i][j] = (up % mod + left % mod) % mod;
        }
      }
    }

    return dp[m - 1][n - 1];
  }
}

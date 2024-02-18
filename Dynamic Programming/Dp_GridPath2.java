public class Dp_GridPath2 {
  int mod = 1_000_000_000 + 7;

  public int totalWays(int N, int M, int grid[][]) {

    // return rec(N - 1, M - 1, grid);

    // int dp[][] = new int[N][M];
    // for(int i = 0; i < N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(N - 1, M - 1, grid, dp);

    return tab(grid, N, M);
  }

  int rec(int i, int j, int grid[][]) {

    if (i == 0 && j == 0)
      return 1;

    if (i < 0 || j < 0)
      return 0;

    if (grid[i][j] == 1)
      return 0;

    int left = rec(i, j - 1, grid);
    int up = rec(i - 1, j, grid);

    return (left % mod + up % mod) % mod;
  }

  int mem(int i, int j, int grid[][], int dp[][]) {

    if (i < 0 || j < 0)
      return 0;

    if (grid[i][j] == 1)
      return 0;

    if (i == 0 && j == 0)
      return 1;

    if (dp[i][j] != -1)
      return dp[i][j];

    int left = rec(i, j - 1, grid);
    int up = rec(i - 1, j, grid);

    return dp[i][j] = (left % mod + up % mod) % mod;
  }

  int tab(int grid[][], int n, int m) {

    int dp[][] = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (grid[i][j] != 1) {

          if (i == 0 && j == 0) {
            dp[i][j] = 1;
          } else {
            int left = 0, up = 0;

            if (i > 0) {
              up = dp[i - 1][j];
            }

            if (j > 0) {
              left = dp[i][j - 1];
            }

            dp[i][j] = (left % mod + up % mod) % mod;
          }
        }

      }
    }

    return dp[n - 1][m - 1];
  }
}

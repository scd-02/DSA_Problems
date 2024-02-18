import java.util.Arrays;

public class Dp_MinimumPathSum {
  public static int minSumPath(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    // return rec(n -1, m - 1, grid);

    int dp[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    // return mem(n - 1, m - 1, grid, dp);

    return tab(grid, n, m);
  }

  static int rec(int i, int j, int grid[][]) {

    if (i == 0 && j == 0)
      return grid[i][j];

    if (i < 0 || j < 0)
      return (int) Math.pow(10, 9);

    int left = grid[i][j] + rec(i, j - 1, grid);
    int up = grid[i][j] + rec(i - 1, j, grid);

    return Math.min(left, up);
  }

  static int mem(int i, int j, int grid[][], int dp[][]) {

    if (i == 0 && j == 0)
      return grid[i][j];

    if (i < 0 || j < 0)
      return (int) Math.pow(10, 9);

    if (dp[i][j] != -1)
      return dp[i][j];

    int left = grid[i][j] + rec(i, j - 1, grid);
    int up = grid[i][j] + rec(i - 1, j, grid);

    return dp[i][j] = Math.min(left, up);
  }

  static int tab(int grid[][], int n, int m) {

    int dp[][] = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else {
          int left = (int) Math.pow(10, 9);
          int up = (int) Math.pow(10, 9);

          if (i > 0)
            up = grid[i][j] + dp[i - 1][j];
          if (j > 0)
            left = grid[i][j] + dp[i][j - 1];

          dp[i][j] = Math.min(left, up);
        }

      }
    }

    return dp[n - 1][m - 1];
  }
}

public class Dp_ChocolatesPickup {
  public int solve(int n, int m, int grid[][]) {
    // return rec(0, 0, m - 1, n, m, grid);

    // int dp[][][] = new int[n][m][m];

    // for(int i = 0; i < n; i++){
    // for(int j = 0; j < m; j++){
    // Arrays.fill(dp[i][j], -1);
    // }
    // }

    // return mem(0, 0, m - 1, n, m, grid, dp);

    return tab(n, m, grid);
  }

  int rec(int i, int j1, int j2, int n, int m, int grid[][]) {

    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
      return (int) Math.pow(-10, 9);

    if (i == n - 1) {

      if (j1 == j2) {
        return grid[i][j1];
      } else {
        return grid[i][j1] + grid[i][j2];
      }

    }

    int max = (int) Math.pow(-10, 9);

    int dir[] = { -1, 0, 1 };

    for (int r1 = 0; r1 < 3; r1++) {
      for (int r2 = 0; r2 < 3; r2++) {

        if (j1 == j2) {
          max = Math.max(max, grid[i][j1] + rec(i + 1, j1 + dir[r1], j2 + dir[r2], n, m, grid));
        } else {
          max = Math.max(max, grid[i][j1] + grid[i][j2] + rec(i + 1, j1 + dir[r1], j2 + dir[r2], n, m, grid));
        }

      }
    }

    return max;
  }

  int mem(int i, int j1, int j2, int n, int m, int grid[][], int dp[][][]) {

    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
      return (int) Math.pow(-10, 9);

    if (i == n - 1) {

      if (j1 == j2) {
        return grid[i][j1];
      } else {
        return grid[i][j1] + grid[i][j2];
      }

    }

    if (dp[i][j1][j2] != -1)
      return dp[i][j1][j2];

    int max = (int) Math.pow(-10, 9);

    int dir[] = { -1, 0, 1 };

    for (int r1 = 0; r1 < 3; r1++) {
      for (int r2 = 0; r2 < 3; r2++) {

        if (j1 == j2) {
          max = Math.max(max, grid[i][j1] + mem(i + 1, j1 + dir[r1], j2 + dir[r2], n, m, grid, dp));
        } else {
          max = Math.max(max, grid[i][j1] + grid[i][j2] + mem(i + 1, j1 + dir[r1], j2 + dir[r2], n, m, grid, dp));
        }

      }
    }

    return dp[i][j1][j2] = max;
  }

  int tab(int n, int m, int grid[][]) {

    int dp[][][] = new int[n][m][m];

    // base case
    for (int j1 = 0; j1 < m; j1++) {
      for (int j2 = 0; j2 < m; j2++) {
        if (j1 == j2)
          dp[n - 1][j1][j2] = grid[n - 1][j1];
        else
          dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {

          int dir[] = { -1, 0, 1 };
          int max = (int) Math.pow(-10, 9);

          for (int r1 = 0; r1 < 3; r1++) {
            for (int r2 = 0; r2 < 3; r2++) {

              int value = 0;

              if (j1 == j2) {
                value = grid[i][j1];
              } else {
                value = grid[i][j1] + grid[i][j2];
              }

              if (j1 + dir[r1] >= 0 && j1 + dir[r1] < m && j2 + dir[r2] >= 0 && j2 + dir[r2] < m) {
                value += dp[i + 1][j1 + dir[r1]][j2 + dir[r2]];
              } else {
                value += (int) Math.pow(-10, 9);
              }

              max = Math.max(value, max);
            }
          }

          dp[i][j1][j2] = max;
        }
      }
    }

    return dp[0][0][m - 1];
  }
}

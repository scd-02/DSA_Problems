public class Dp_MinimumPointsToReachDestination {
  public int minPoints(int points[][], int m, int n) {

    // return rec(0, 0, m, n, points);

    // int dp[][] = new int[m][n];
    // for(int i = 0; i < m; i++){
    // Arrays.fill(dp[i], -1);
    // }
    // return mem(0, 0, m, n, points, dp);

    return tab(m, n, points);
  }

  public int rec(int i, int j, int m, int n, int points[][]) {

    if (i >= m || j >= n)
      return (int) 10e9;

    if (i == m - 1 && j == n - 1) {
      return points[i][j] > 0 ? 1 : Math.abs(points[i][j]) + 1;
    }

    int min_points = Math.min(rec(i + 1, j, m, n, points), rec(i, j + 1, m, n, points));
    return Math.max(1, min_points - points[i][j]);
  }

  public int mem(int i, int j, int m, int n, int points[][], int dp[][]) {

    if (i >= m || j >= n)
      return (int) 10e9;

    if (i == m - 1 && j == n - 1) {
      return dp[i][j] = points[i][j] > 0 ? 1 : Math.abs(points[i][j]) + 1;
    }

    if (dp[i][j] != -1)
      return dp[i][j];

    int min_points = Math.min(mem(i + 1, j, m, n, points, dp), mem(i, j + 1, m, n, points, dp));
    return dp[i][j] = Math.max(1, min_points - points[i][j]);
  }

  public int tab(int m, int n, int points[][]) {

    int dp[][] = new int[m][n];

    dp[m - 1][n - 1] = points[m - 1][n - 1] > 0 ? 1 : Math.abs(points[m - 1][n - 1]) + 1;

    for (int i = m - 2; i >= 0; i--)
      dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - points[i][n - 1], 1);

    for (int j = n - 2; j >= 0; j--)
      dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - points[m - 1][j], 1);

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {

        int min_points = Math.min(dp[i + 1][j], dp[i][j + 1]);
        dp[i][j] = Math.max(1, min_points - points[i][j]);

      }
    }
    return dp[0][0];
  }
}

public class Dp_MaximumNumberOfPointsWithCost {
  public long maxPoints(int[][] points) {
    int n = points.length, m = points[0].length;

    // long dp[][] = new long[n][m];
    // for(int i = 0; i < n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // long res = 0;
    // for(int c = 0; c < m; c++){
    // res = Math.max(res, mem(points, n - 1, c, dp));
    // }

    // return res;

    return tab(points, n, m);
  }

  public long mem(int points[][], int currRow, int currCol, long dp[][]) {

    if (currRow < 0)
      return 0;

    if (dp[currRow][currCol] != -1)
      return dp[currRow][currCol];
    long maxPoints = 0;

    for (int i = 0; i < points[0].length; i++) {
      long currPoints = points[currRow][currCol] - Math.abs(currCol - i) + mem(points, currRow - 1, i, dp);
      maxPoints = Math.max(currPoints, maxPoints);
    }

    return dp[currRow][currCol] = maxPoints;
  }

  public long tab(int points[][], int n, int m) {

    long prev[] = new long[m];

    for (int c = 0; c < m; c++) {
      prev[c] = points[0][c];
    }

    for (int row = 1; row < n; row++) {
      long curr[] = new long[m];

      long runningMax = 0;
      for (int col = 0; col < m; col++) {
        runningMax = Math.max(runningMax - 1, prev[col]);
        curr[col] = runningMax;
      }

      runningMax = 0;
      for (int col = m - 1; col >= 0; col--) {
        runningMax = Math.max(runningMax - 1, prev[col]);
        curr[col] = Math.max(curr[col], runningMax) + points[row][col];
      }

      prev = curr;
    }

    long res = 0;
    for (long ele : prev) {
      res = Math.max(ele, res);
    }

    return res;
  }
}

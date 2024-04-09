import java.util.Arrays;

public class Dp_OptimalStrategyForAGame {
  static long countMaximum(int n, int arr[]) {
    // return rec(0, n - 1, n, arr);
    long dp[][] = new long[n][n];
    for(int i = 0; i < n; i++){
      Arrays.fill(dp[i], -1);
    }
    return mem(0, n - 1, n, arr, dp);
  }

  static long rec(int i, int j, int n, int arr[]) {

    if (i > j || i >= n || j < 0)
      return 0;

    long first = arr[i] + Math.min(rec(i + 1, j - 1, n, arr), rec(i + 2, j, n, arr));
    long last = arr[j] + Math.min(rec(i + 1, j - 1, n, arr), rec(i, j - 2, n, arr));

    return Math.max(first, last);

  }

  static long mem(int i, int j, int n, int arr[], long dp[][]) {

    if (i > j || i >= n || j < 0)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    long first = arr[i] + Math.min(mem(i + 1, j - 1, n, arr, dp), mem(i + 2, j, n, arr, dp));
    long last = arr[j] + Math.min(mem(i + 1, j - 1, n, arr, dp), mem(i, j - 2, n, arr, dp));

    return dp[i][j] = Math.max(first, last);

  }
}

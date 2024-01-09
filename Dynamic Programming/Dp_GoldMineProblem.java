import java.util.Arrays;

public class Dp_GoldMineProblem {
  /*
   * Given a gold mine called M of (n x m) dimensions. Each field in this mine
   * contains a positive integer which is the amount of gold in tons. Initially
   * the miner can start from any row in the first column. From a given cell, the
   * miner can move
   * 
   * to the cell diagonally up towards the right
   * to the right
   * to the cell diagonally down towards the right
   * Find out maximum amount of gold which he can collect until he can no longer
   * move.
   */

  static int maxGold(int n, int m, int M[][]) {
    int dp[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      max = Math.max(max, solve_dp_rec(i, 0, n, m, M, dp));
    }

    return max;
  }

  static int solve_dp(int n, int m, int arr[][]) {

    int dp[][] = new int[n][m];

    for (int j = m - 1; j >= 0; j--) {
      for (int i = 0; i < n; i++) {

        int d_up = (i - 1 >= 0 && j + 1 < m) ? dp[i - 1][j + 1] : 0;
        int right = (j + 1 < m) ? dp[i][j + 1] : 0;
        int d_down = (i + 1 < n && j + 1 < m) ? dp[i + 1][j + 1] : 0;

        dp[i][j] = arr[i][j] + Math.max(right, Math.max(d_up, d_down));

      }
    }

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i][0]);
    }

    return max;
  }

  static int solve_dp_rec(int cr, int cc, int n, int m, int arr[][], int ans[][]) {

    if (cr < 0 || cr >= n || cc < 0 || cc >= m)
      return 0;

    if (ans[cr][cc] != -1) {
      return ans[cr][cc];
    }

    int d_up = arr[cr][cc] + solve_dp_rec(cr - 1, cc + 1, n, m, arr, ans);
    int right = arr[cr][cc] + solve_dp_rec(cr, cc + 1, n, m, arr, ans);
    int d_down = arr[cr][cc] + solve_dp_rec(cr + 1, cc + 1, n, m, arr, ans);

    ans[cr][cc] = Math.max(right, Math.max(d_up, d_down));

    return ans[cr][cc];
  }

  static void solve(int cr, int cc, int n, int m, int arr[][], int ans[], int sum) {

    if (cr < 0 || cr >= n || cc < 0 || cc >= m)
      return;

    if (cc == m - 1) {

      ans[0] = Math.max(ans[0], sum + arr[cr][cc]);
      return;
    }

    solve(cr - 1, cc + 1, n, m, arr, ans, sum + arr[cr][cc]);
    solve(cr, cc + 1, n, m, arr, ans, sum + arr[cr][cc]);
    solve(cr + 1, cc + 1, n, m, arr, ans, sum + arr[cr][cc]);
  }
}

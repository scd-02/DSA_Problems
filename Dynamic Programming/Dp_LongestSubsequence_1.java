public class Dp_LongestSubsequence_1 {
  static int longestSubsequence(int n, int a[]) {
    // recursion
    // return solve(a, -1, 0, n);

    // dp approach
    int dp[][] = new int[n][n + 1];

    for (int i = 0; i <= n - 1; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = -1;
      }
    }

    return solve1(a, -1, 0, n, dp);
  }

  static int solve(int a[], int prev, int curr, int n) {

    if (curr >= n) {
      return 0;
    }

    // include
    int include = 0;
    if (prev == -1 || Math.abs(a[curr] - a[prev]) == 1) {
      include = 1 + solve(a, curr, curr + 1, n);
    }

    // not include
    int exclude = solve(a, prev, curr + 1, n);

    return Math.max(include, exclude);

  }

  static int solve1(int a[], int prev, int curr, int n, int dp[][]) {

    if (curr >= n) {
      return 0;
    }

    if (dp[curr][prev + 1] != -1) {
      return dp[curr][prev + 1];
    }

    // include
    int include = 0;
    if (prev == -1 || Math.abs(a[curr] - a[prev]) == 1) {
      include = 1 + solve1(a, curr, curr + 1, n, dp);
    }

    // not include
    int exclude = solve1(a, prev, curr + 1, n, dp);

    return dp[curr][prev + 1] = Math.max(include, exclude);

  }
}

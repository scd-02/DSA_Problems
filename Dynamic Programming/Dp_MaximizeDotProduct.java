public class Dp_MaximizeDotProduct {
  public int maxDotProduct(int n, int m, int a[], int b[]) {
    // return rec(a, b, n - 1, m - 1);

    // int dp[][] = new int[n][m];
    // for(int i = 0; i < n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(a, b, n - 1, m - 1, dp);

    // return tab(a, b, n, m);
    return so(a, b, n, m);
  }

  public int rec(int a[], int b[], int i, int j) {

    if (i < 0 || j < 0)
      return 0;

    int not_take = 0 + rec(a, b, i - 1, j);

    int take = 0;
    if (i >= j) {
      take = a[i] * b[j] + rec(a, b, i - 1, j - 1);
    }

    return Math.max(not_take, take);
  }

  public int mem(int a[], int b[], int i, int j, int dp[][]) {

    if (i < 0 || j < 0)
      return 0;

    if (dp[i][j] != -1)
      return dp[i][j];

    int not_take = 0 + mem(a, b, i - 1, j, dp);

    int take = 0;
    if (i >= j) {
      take = a[i] * b[j] + mem(a, b, i - 1, j - 1, dp);
    }

    return dp[i][j] = Math.max(not_take, take);
  }

  public int tab(int a[], int b[], int n, int m) {

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        int not_take = 0 + dp[i - 1][j];

        int take = 0;
        if (i >= j) {
          take = a[i - 1] * b[j - 1] + dp[i - 1][j - 1];
        }

        dp[i][j] = Math.max(not_take, take);
      }
    }
    return dp[n][m];
  }

  public int so(int a[], int b[], int n, int m) {

    int prev[] = new int[m + 1];

    for (int i = 1; i <= n; i++) {
      int curr[] = new int[m + 1];
      for (int j = 1; j <= m; j++) {

        int not_take = 0 + prev[j];

        int take = 0;
        if (i >= j) {
          take = a[i - 1] * b[j - 1] + prev[j - 1];
        }

        curr[j] = Math.max(not_take, take);
      }
      prev = curr;
    }
    return prev[m];
  }
}

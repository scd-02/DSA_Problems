public class Dp_KnapSackProblem {
  static int knapSack(int W, int wt[], int val[], int n) {
    // return rec(n - 1, W, wt, val, n);

    // int dp[][] = new int[n][W + 1];

    // for(int i = 0; i < n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(n - 1, W, wt, val, n, dp);

    // return tab(W, wt, val, n);
    return so2(W, wt, val, n);
  }

  static int rec(int i, int w, int wt[], int val[], int n) {

    if (i == 0) {
      if (wt[i] <= w)
        return val[i];
      else
        return 0;
    }

    int not_take = 0 + rec(i - 1, w, wt, val, n);
    int take = Integer.MIN_VALUE;

    if (wt[i] <= w) {
      take = val[i] + rec(i - 1, w - wt[i], wt, val, n);
    }

    return Math.max(take, not_take);
  }

  static int mem(int i, int w, int wt[], int val[], int n, int dp[][]) {

    if (i == 0) {
      if (wt[i] <= w)
        return val[i];
      else
        return 0;
    }

    if (dp[i][w] != -1)
      return dp[i][w];

    int not_take = 0 + mem(i - 1, w, wt, val, n, dp);
    int take = Integer.MIN_VALUE;

    if (wt[i] <= w) {
      take = val[i] + mem(i - 1, w - wt[i], wt, val, n, dp);
    }

    return dp[i][w] = Math.max(take, not_take);

  }

  static int tab(int W, int wt[], int val[], int n) {

    int dp[][] = new int[n][W + 1];

    for (int w = wt[0]; w <= W; w++)
      dp[0][w] = val[0];

    for (int i = 1; i < n; i++) {
      for (int w = 0; w <= W; w++) {

        int not_take = 0 + dp[i - 1][w];
        int take = Integer.MIN_VALUE;

        if (wt[i] <= w) {
          take = val[i] + dp[i - 1][w - wt[i]];
        }

        dp[i][w] = Math.max(take, not_take);
      }
    }

    return dp[n - 1][W];
  }

  static int so(int W, int wt[], int val[], int n) {

    int prev[] = new int[W + 1];

    for (int w = wt[0]; w <= W; w++)
      prev[w] = val[0];

    for (int i = 1; i < n; i++) {
      int curr[] = new int[W + 1];

      for (int w = 0; w <= W; w++) {

        int not_take = 0 + prev[w];
        int take = Integer.MIN_VALUE;

        if (wt[i] <= w) {
          take = val[i] + prev[w - wt[i]];
        }

        curr[w] = Math.max(take, not_take);
      }

      prev = curr;
    }

    return prev[W];

  }

  static int so2(int W, int wt[], int val[], int n) {

    int prev[] = new int[W + 1];

    for (int w = wt[0]; w <= W; w++)
      prev[w] = val[0];

    for (int i = 1; i < n; i++) {

      for (int w = W; w >= 0; w--) {

        int not_take = 0 + prev[w];
        int take = Integer.MIN_VALUE;

        if (wt[i] <= w) {
          take = val[i] + prev[w - wt[i]];
        }

        prev[w] = Math.max(take, not_take);
      }

    }

    return prev[W];
  }
}

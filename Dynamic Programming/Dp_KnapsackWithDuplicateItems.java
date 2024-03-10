public class Dp_KnapsackWithDuplicateItems {
  static int knapSack(int N, int W, int val[], int wt[]) {

    // return rec(N - 1, W, val, wt);

    // int dp[][] = new int [N][W + 1];
    // for(int i = 0; i < N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(N - 1, W, val, wt, dp);

    return tab(N, W, val, wt);
  }

  static int rec(int i, int w, int val[], int wt[]) {

    if (i == 0) {
      return (int) (w / wt[0]) * val[0];
    }

    int not_take = 0 + rec(i - 1, w, val, wt);

    int take = Integer.MIN_VALUE;

    if (wt[i] <= w) {
      take = val[i] + rec(i, w - wt[i], val, wt);
    }

    return Math.max(not_take, take);
  }

  static int mem(int i, int w, int val[], int wt[], int dp[][]) {

    if (i == 0) {
      return (int) (w / wt[0]) * val[0];
    }

    if (dp[i][w] != -1)
      return dp[i][w];

    int not_take = 0 + mem(i - 1, w, val, wt, dp);

    int take = Integer.MIN_VALUE;

    if (wt[i] <= w) {
      take = val[i] + mem(i, w - wt[i], val, wt, dp);
    }

    return dp[i][w] = Math.max(not_take, take);
  }

  static int tab(int n, int W, int val[], int wt[]) {

    int dp[][] = new int[n][W + 1];

    for (int w = 0; w <= W; w++) {
      dp[0][w] = (int) (w / wt[0]) * val[0];
    }

    for (int i = 1; i < n; i++) {
      for (int w = 0; w <= W; w++) {

        int not_take = 0 + dp[i - 1][w];

        int take = Integer.MIN_VALUE;

        if (wt[i] <= w) {
          take = val[i] + dp[i][w - wt[i]];
        }

        dp[i][w] = Math.max(not_take, take);

      }
    }

    return dp[n - 1][W];
  }

  static int so(int N, int W, int val[], int wt[]) {
    int prev[] = new int[W + 1];
    int curr[] = new int[W + 1];

    for (int w = 1; w <= W; w++) {
      for (int i = 0; i < N; i++) {

        if (w < wt[i]) {
          curr[w] = prev[w];
        } else {
          int excluded = prev[w];
          int included = val[i] + prev[w - wt[i]];
          int self = val[i] + curr[w - wt[i]];

          curr[w] = Math.max(Math.max(included, excluded), self);
        }

        prev = curr;
      }
    }

    return prev[W];
  }
}

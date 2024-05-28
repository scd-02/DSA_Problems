import java.util.Arrays;

public class Dp_MinimumCostToFillGivenWeightInABag {
  public static int minimumCost(int n, int w, int[] cost) {

    // int ans = rec(cost, n, w);

    // int dp[][] = new int[n + 1][w + 1];
    // for(int i = 0; i <= n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // int ans = mem(cost, n, w, dp);

    // int ans = tab(cost, n, w);
    int ans = so(cost, n, w);
    return ans >= (int) 10e8 ? -1 : ans;
  }

  static int rec(int cost[], int ind, int w) {

    if (ind == 0)
      return (int) 10e8;

    if (w == 0)
      return 0;

    // not take
    int not_take = rec(cost, ind - 1, w);

    // take
    int take = (int) 10e8;
    if (cost[ind - 1] != -1 && w - ind >= 0) {
      take = cost[ind - 1] + rec(cost, ind, w - ind);
    }

    return Math.min(not_take, take);
  }

  static int mem(int cost[], int ind, int w, int dp[][]) {
    if (ind == 0)
      return (int) 10e8;

    if (w == 0)
      return 0;

    if (dp[ind][w] != -1)
      return dp[ind][w];
    // not take
    int not_take = mem(cost, ind - 1, w, dp);

    // take
    int take = (int) 10e8;
    if (cost[ind - 1] != -1 && w - ind >= 0) {
      take = cost[ind - 1] + mem(cost, ind, w - ind, dp);
    }

    return dp[ind][w] = Math.min(not_take, take);
  }

  static int tab(int cost[], int n, int W) {

    int dp[][] = new int[n + 1][W + 1];

    Arrays.fill(dp[0], (int) 10e8);

    dp[0][0] = 0;

    for (int ind = 1; ind <= n; ind++) {
      for (int w = 1; w <= W; w++) {

        int not_take = dp[ind - 1][w];
        int take = (int) 10e8;

        if (cost[ind - 1] != -1 && w - ind >= 0) {
          take = cost[ind - 1] + dp[ind][w - ind];
        }

        dp[ind][w] = Math.min(take, not_take);
      }
    }

    return dp[n][W];
  }

  static int so(int cost[], int n, int W) {

    int prev[] = new int[W + 1];

    Arrays.fill(prev, (int) 10e8);

    prev[0] = 0;

    for (int ind = 1; ind <= n; ind++) {
      int curr[] = new int[W + 1];

      for (int w = 1; w <= W; w++) {

        int not_take = prev[w];
        int take = (int) 10e8;

        if (cost[ind - 1] != -1 && w - ind >= 0) {
          take = cost[ind - 1] + curr[w - ind];
        }

        curr[w] = Math.min(take, not_take);
      }
      prev = curr;
    }

    return prev[W];
  }
}

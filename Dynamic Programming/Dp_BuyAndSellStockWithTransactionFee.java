public class Dp_BuyAndSellStockWithTransactionFee {
  public long maximumProfit(long prices[], int N, int fee) {

    // return rec(0, 1, N, prices, fee);

    // long dp[][] = new long[N + 1][2];
    // for(int i = 0; i <= N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, 1, N, prices, dp, fee);

    // return tab(prices, N, fee);

    return so(prices, N, fee);
  }

  public long rec(int i, int buy, int n, long prices[], int fee) {

    if (i == n)
      return 0;

    if (buy == 1) {
      return Math.max(-prices[i] - fee + rec(i + 1, 0, n, prices, fee), 0 + rec(i + 1, 1, n, prices, fee));
    }

    return Math.max(prices[i] + rec(i + 1, 1, n, prices, fee), 0 + rec(i + 1, 0, n, prices, fee));
  }

  public long mem(int i, int buy, int n, long prices[], long dp[][], int fee) {

    if (i == n)
      return 0;

    if (dp[i][buy] != -1)
      return dp[i][buy];

    if (buy == 1) {
      return dp[i][buy] = Math.max(-prices[i] - fee + mem(i + 1, 0, n, prices, dp, fee),
          0 + mem(i + 1, 1, n, prices, dp, fee));
    }

    return dp[i][buy] = Math.max(prices[i] + mem(i + 1, 1, n, prices, dp, fee),
        0 + mem(i + 1, 0, n, prices, dp, fee));

  }

  public long tab(long prices[], int n, int fee) {

    long dp[][] = new long[n + 1][2];

    for (int i = n - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {

        if (buy == 1) {
          dp[i][buy] = Math.max(-prices[i] - fee + dp[i + 1][0], 0 + dp[i + 1][1]);
        } else {
          dp[i][buy] = Math.max(prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
        }

      }
    }

    return dp[0][1];
  }

  public long so(long prices[], int n, int fee) {

    long ahead1[] = new long[2];

    for (int i = n - 1; i >= 0; i--) {
      long curr[] = new long[2];

      curr[1] = Math.max(-prices[i] - fee + ahead1[0], 0 + ahead1[1]);

      curr[0] = Math.max(prices[i] + ahead1[1], 0 + ahead1[0]);

      ahead1 = curr;
    }

    return ahead1[1];
  }
}

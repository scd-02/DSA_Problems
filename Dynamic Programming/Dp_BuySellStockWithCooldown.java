public class Dp_BuySellStockWithCooldown {
  public int maxProfit(int[] prices) {

    int obsp = -prices[0];
    int ossp = 0;
    int ocsp = 0;

    for (int i = 1; i < prices.length; i++) {

      int nbsp = 0;
      int nssp = 0;
      int ncsp = 0;

      nbsp = (ocsp - prices[i] > obsp) ? ocsp - prices[i] : obsp;
      nssp = (obsp + prices[i] > ossp) ? obsp + prices[i] : ossp;
      ncsp = (ossp > ocsp) ? ossp : ocsp;

      obsp = nbsp;
      ossp = nssp;
      ocsp = ncsp;
    }

    return ossp;
  }

  public long maximumProfit(long prices[], int N) {

    // return rec(0, 1, N, prices)

    // long dp[][] = new long[N + 1][2];
    // for(int i = 0; i <= N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, 1, N, prices, dp);

    // return tab(prices, N);

    return so(prices, N);
  }

  public long rec(int i, int buy, int n, long prices[]) {

    if (i >= n)
      return 0;

    if (buy == 1) {
      return Math.max(-prices[i] + rec(i + 1, 0, n, prices), 0 + rec(i + 1, 1, n, prices));
    }

    return Math.max(prices[i] + rec(i + 2, 1, n, prices), 0 + rec(i + 1, 0, n, prices));
  }

  public long mem(int i, int buy, int n, long prices[], long dp[][]) {

    if (i >= n)
      return 0;

    if (dp[i][buy] != -1)
      return dp[i][buy];

    if (buy == 1) {
      return dp[i][buy] = Math.max(-prices[i] + mem(i + 1, 0, n, prices, dp), 0 + mem(i + 1, 1, n, prices, dp));
    }

    return dp[i][buy] = Math.max(prices[i] + mem(i + 2, 1, n, prices, dp), 0 + mem(i + 1, 0, n, prices, dp));

  }

  public long tab(long prices[], int n) {

    long dp[][] = new long[n + 2][2];

    for (int i = n - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {

        if (buy == 1) {
          dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
        } else {
          dp[i][buy] = Math.max(prices[i] + dp[i + 2][1], 0 + dp[i + 1][0]);
        }

      }
    }

    return dp[0][1];
  }

  public long so(long prices[], int n) {

    long ahead2[] = new long[2];
    long ahead1[] = new long[2];

    for (int i = n - 1; i >= 0; i--) {
      long curr[] = new long[2];

      curr[1] = Math.max(-prices[i] + ahead1[0], 0 + ahead1[1]);

      curr[0] = Math.max(prices[i] + ahead2[1], 0 + ahead1[0]);

      ahead2 = ahead1;
      ahead1 = curr;
    }

    return ahead1[1];
  }
}

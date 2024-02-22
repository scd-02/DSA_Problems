public class Dp_BuyAndSellStock2 {
  public static int stockBuyAndSell(int n, int[] prices) {

    // return rec(0, 1, prices, n);

    // int dp[][] = new int[n][2];
    // for(int i = 0; i < n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, 1, prices, n, dp);

    // return tab(prices, n);

    // return so(prices, n);

    return so_var(prices, n);
  }

  static int rec(int i, int can_buy, int prices[], int n) {

    if (i == n)
      return 0;

    int profit = 0;

    if (can_buy == 1) {
      int buy = -prices[i] + rec(i + 1, 0, prices, n);
      int not_buy = 0 + rec(i + 1, 1, prices, n);

      profit = Math.max(buy, not_buy);

    } else {

      int sell = prices[i] + rec(i + 1, 1, prices, n);
      int not_sell = 0 + rec(i + 1, 0, prices, n);

      profit = Math.max(sell, not_sell);
    }

    return profit;
  }

  static int mem(int i, int can_buy, int prices[], int n, int dp[][]) {

    if (i == n)
      return 0;

    if (dp[i][can_buy] != -1)
      return dp[i][can_buy];

    int profit = 0;

    if (can_buy == 1) {
      int buy = -prices[i] + mem(i + 1, 0, prices, n, dp);
      int not_buy = 0 + mem(i + 1, 1, prices, n, dp);

      profit = Math.max(buy, not_buy);

    } else {

      int sell = prices[i] + mem(i + 1, 1, prices, n, dp);
      int not_sell = 0 + mem(i + 1, 0, prices, n, dp);

      profit = Math.max(sell, not_sell);
    }

    return dp[i][can_buy] = profit;

  }

  static int tab(int prices[], int n) {

    int dp[][] = new int[n + 1][2];

    dp[n][0] = dp[n][1] = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int can_buy = 0; can_buy <= 1; can_buy++) {

        int profit = 0;

        if (can_buy == 1) {
          int buy = -prices[i] + dp[i + 1][0];
          int not_buy = 0 + dp[i + 1][1];

          profit = Math.max(buy, not_buy);

        } else {

          int sell = prices[i] + dp[i + 1][1];
          int not_sell = 0 + dp[i + 1][0];

          profit = Math.max(sell, not_sell);
        }

        dp[i][can_buy] = profit;

      }
    }

    return dp[0][1];
  }

  static int so(int prices[], int n) {

    int ahead[] = new int[2];
    int curr[] = new int[2];

    ahead[0] = ahead[1] = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int can_buy = 0; can_buy <= 1; can_buy++) {

        if (can_buy == 1) {
          int buy = -prices[i] + ahead[0];
          int not_buy = 0 + ahead[1];

          curr[1] = Math.max(buy, not_buy);

        } else {

          int sell = prices[i] + ahead[1];
          int not_sell = 0 + ahead[0];

          curr[0] = Math.max(sell, not_sell);
        }

        ahead = curr;

      }
    }

    return ahead[1];
  }

  static int so_var(int prices[], int n) {

    int aheadBuy, aheadNotBuy;
    int currBuy, currNotBuy;

    aheadNotBuy = aheadBuy = 0;

    for (int i = n - 1; i >= 0; i--) {
      currBuy = Math.max(-prices[i] + aheadNotBuy, 0 + aheadBuy);
      currNotBuy = Math.max(prices[i] + aheadBuy, 0 + aheadNotBuy);

      aheadBuy = currBuy;
      aheadNotBuy = currNotBuy;

    }

    return aheadBuy;
  }
}

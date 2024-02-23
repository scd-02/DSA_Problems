public class Dp_BuyAndSellStock3 {
  public static int maxProfit(int n, int[] prices) {
    // return rec(0, 1, 2, prices, n);

    // int dp[][][] = new int[n][2][3];
    // for(int i = 0; i < n; i++){
    // for(int j = 0; j <= 1; j++){
    // Arrays.fill(dp[i][j], -1);
    // }
    // }

    // return mem(0, 1, 2, prices, n, dp);

    return tab(prices, n);
  }

  static int rec(int i, int can_buy, int cap, int prices[], int n) {

    if (i == n || cap == 0)
      return 0;

    if (can_buy == 1) {

      return Math.max(-prices[i] + rec(i + 1, 0, cap, prices, n),
          0 + rec(i + 1, 1, cap, prices, n));

    }

    return Math.max(prices[i] + rec(i + 1, 1, cap - 1, prices, n),
        0 + rec(i + 1, 0, cap, prices, n));

  }

  static int mem(int i, int can_buy, int cap, int prices[], int n, int dp[][][]) {

    if (i == n || cap == 0)
      return 0;

    if (dp[i][can_buy][cap] != -1)
      return dp[i][can_buy][cap];

    if (can_buy == 1) {

      return dp[i][can_buy][cap] = Math.max(-prices[i] + mem(i + 1, 0, cap, prices, n, dp),
          0 + mem(i + 1, 1, cap, prices, n, dp));

    }

    return dp[i][can_buy][cap] = Math.max(prices[i] + mem(i + 1, 1, cap - 1, prices, n, dp),
        0 + mem(i + 1, 0, cap, prices, n, dp));

  }

  static int tab(int prices[], int n) {

    int dp[][][] = new int[n + 1][2][3];

    // base case as initialization of array is already filled with 0

    for (int i = n - 1; i >= 0; i--) {
      for (int can_buy = 0; can_buy <= 1; can_buy++) {
        for (int cap = 1; cap <= 2; cap++) {

          if (can_buy == 1) {

            dp[i][can_buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap],
                0 + dp[i + 1][1][cap]);

          } else {

            dp[i][can_buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1],
                0 + dp[i + 1][0][cap]);

          }

        }
      }
    }

    return dp[0][1][2];
  }
}

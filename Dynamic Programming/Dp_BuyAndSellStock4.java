public class Dp_BuyAndSellStock4 {
  static int maxProfit(int K, int N, int A[]) {
    // return rec(0, 0, A, N, K);

    // int dp[][] = new int[N + 1][2 * K + 1];
    // for(int i = 0; i < N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, 0, A, N, K, dp);

    // return tab(A, N, K);

    return so(A, N, K);

  }

  static int rec(int i, int tranNo, int prices[], int n, int k) {

    if (i == n || tranNo == 2 * k)
      return 0;

    if ((tranNo % 2) == 0) {
      return Math.max(-prices[i] + rec(i + 1, tranNo + 1, prices, n, k),
          0 + rec(i + 1, tranNo, prices, n, k));
    }

    return Math.max(prices[i] + rec(i + 1, tranNo + 1, prices, n, k),
        0 + rec(i + 1, tranNo, prices, n, k));
  }

  static int mem(int i, int tranNo, int prices[], int n, int k, int dp[][]) {

    if (i == n || tranNo == 2 * k)
      return 0;

    if (dp[i][tranNo] != -1)
      return dp[i][tranNo];

    if ((tranNo % 2) == 0) {
      return dp[i][tranNo] = Math.max(-prices[i] + mem(i + 1, tranNo + 1, prices, n, k, dp),
          0 + mem(i + 1, tranNo, prices, n, k, dp));
    }

    return dp[i][tranNo] = Math.max(prices[i] + mem(i + 1, tranNo + 1, prices, n, k, dp),
        0 + mem(i + 1, tranNo, prices, n, k, dp));
  }

  static int tab(int prices[], int n, int k) {

    int dp[][] = new int[n + 1][2 * k + 1];

    for (int i = n - 1; i >= 0; i--) {
      for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
        if ((tranNo % 2) == 0) {
          dp[i][tranNo] = Math.max(-prices[i] + dp[i + 1][tranNo + 1],
              0 + dp[i + 1][tranNo]);
        } else {

          dp[i][tranNo] = Math.max(prices[i] + dp[i + 1][tranNo + 1],
              0 + dp[i + 1][tranNo]);
        }
      }
    }

    return dp[0][0];
  }

  static int so(int prices[], int n, int k) {

    int ahead[] = new int[2 * k + 1];
    int curr[] = new int[2 * k + 1];

    for (int i = n - 1; i >= 0; i--) {
      for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
        if ((tranNo % 2) == 0) {
          curr[tranNo] = Math.max(-prices[i] + ahead[tranNo + 1],
              0 + ahead[tranNo]);
        } else {

          curr[tranNo] = Math.max(prices[i] + ahead[tranNo + 1],
              0 + ahead[tranNo]);
        }
      }
      ahead = curr;
    }

    return ahead[0];
  }
}

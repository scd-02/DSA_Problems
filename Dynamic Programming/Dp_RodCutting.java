public class Dp_RodCutting {
  public int cutRod(int price[], int n) {

    // return rec(n - 1, n, price);
    // int dp[][] = new int[n][n + 1];
    // for(int i = 0; i < n; i++){
    // Arrays.fill(dp[i], -1);
    // }
    // return mem(n - 1, n, price, dp);

    // return tab(n, price);
    return so2(n, price);
  }

  int rec(int i, int len, int price[]) {

    if (i == 0) {
      return len * price[i];
    }

    int not_take = 0 + rec(i - 1, len, price);

    int take = Integer.MIN_VALUE;
    int rodLen = i + 1;
    if (rodLen <= len) {
      take = price[i] + rec(i, len - rodLen, price);
    }

    return Math.max(take, not_take);

  }

  int mem(int i, int len, int price[], int dp[][]) {

    if (i == 0) {
      return len * price[i];
    }

    if (dp[i][len] != -1)
      return dp[i][len];

    int not_take = 0 + mem(i - 1, len, price, dp);

    int take = Integer.MIN_VALUE;
    int rodLen = i + 1;
    if (rodLen <= len) {
      take = price[i] + mem(i, len - rodLen, price, dp);
    }

    return dp[i][len] = Math.max(take, not_take);

  }

  int tab(int n, int price[]) {

    int dp[][] = new int[n][n + 1];

    for (int len = 0; len <= n; len++) {
      dp[0][len] = len * price[0];
    }

    for (int i = 1; i < n; i++) {
      for (int len = 0; len <= n; len++) {
        int not_take = 0 + dp[i - 1][len];

        int take = Integer.MIN_VALUE;
        int rodLen = i + 1;

        if (rodLen <= len) {
          take = price[i] + dp[i][len - rodLen];
        }

        dp[i][len] = Math.max(take, not_take);
      }
    }

    return dp[n - 1][n];
  }

  int so(int n, int price[]) {

    int prev[] = new int[n + 1];

    for (int len = 0; len <= n; len++) {
      prev[len] = len * price[0];
    }

    for (int i = 1; i < n; i++) {
      int curr[] = new int[n + 1];
      for (int len = 0; len <= n; len++) {
        int not_take = 0 + prev[len];

        int take = Integer.MIN_VALUE;
        int rodLen = i + 1;

        if (rodLen <= len) {
          take = price[i] + curr[len - rodLen];
        }

        curr[len] = Math.max(take, not_take);
      }
      prev = curr;
    }

    return prev[n];
  }

  int so2(int n, int price[]) {

    int prev[] = new int[n + 1];

    for (int len = 0; len <= n; len++) {
      prev[len] = len * price[0];
    }

    for (int i = 1; i < n; i++) {
      for (int len = 0; len <= n; len++) {
        int not_take = 0 + prev[len];

        int take = Integer.MIN_VALUE;
        int rodLen = i + 1;

        if (rodLen <= len) {
          take = price[i] + prev[len - rodLen];
        }

        prev[len] = Math.max(take, not_take);
      }
    }

    return prev[n];
  }
}

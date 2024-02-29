public class Dp_CoinChange {
  public int minCoins(int coins[], int M, int V) {
    // int ans = rec(M - 1, V, coins);
    // return ans == (int) 10e8 ? -1 : ans;

    // int dp[][] = new int[M][V + 1];
    // for(int i = 0; i < M; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // int ans = mem(M - 1, V, coins, dp);
    // return ans == (int) 10e8 ? -1 : ans;

    return so(coins, V, M);
  }

  public int rec(int i, int v, int coins[]) {

    if (i == 0) {

      if ((v % coins[i]) == 0)
        return v / coins[i];
      else
        return (int) 10e8;

    }

    int not_take = 0 + rec(i - 1, v, coins);
    int take = (int) 10e8;

    if (coins[i] <= v) {
      take = 1 + rec(i, v - coins[i], coins);
    }

    return Math.min(take, not_take);
  }

  public int mem(int i, int v, int coins[], int dp[][]) {

    if (i == 0) {

      if ((v % coins[i]) == 0)
        return v / coins[i];
      else
        return (int) 10e8;

    }

    if (dp[i][v] != -1)
      return dp[i][v];

    int not_take = 0 + mem(i - 1, v, coins, dp);
    int take = (int) 10e8;

    if (coins[i] <= v) {
      take = 1 + mem(i, v - coins[i], coins, dp);
    }

    return dp[i][v] = Math.min(take, not_take);
  }

  public int tab(int coins[], int V, int m) {

    int dp[][] = new int[m][V + 1];

    for (int v = 0; v <= V; v++) {
      if ((v % coins[0]) == 0) {
        dp[0][v] = v / coins[0];
      } else {
        dp[0][v] = (int) 10e8;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int v = 0; v <= V; v++) {

        int not_take = 0 + dp[i - 1][v];
        int take = (int) 10e8;

        if (coins[i] <= v) {
          take = 1 + dp[i][v - coins[i]];
        }

        dp[i][v] = Math.min(take, not_take);
      }
    }

    return dp[m - 1][V] == (int) 10e8 ? -1 : dp[m - 1][V];
  }

  public int so(int coins[], int V, int m) {

    int prev[] = new int[V + 1];

    for (int v = 0; v <= V; v++) {
      if ((v % coins[0]) == 0) {
        prev[v] = v / coins[0];
      } else {
        prev[v] = (int) 10e8;
      }
    }

    for (int i = 1; i < m; i++) {
      int curr[] = new int[V + 1];
      for (int v = 0; v <= V; v++) {

        int not_take = 0 + prev[v];
        int take = (int) 10e8;

        if (coins[i] <= v) {
          take = 1 + curr[v - coins[i]];
        }

        curr[v] = Math.min(take, not_take);
      }
      prev = curr;
    }

    return prev[V] == (int) 10e8 ? -1 : prev[V];
  }
}

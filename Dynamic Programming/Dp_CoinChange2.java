public class Dp_CoinChange2 {
  public long count(int coins[], int N, int sum) {
    // return rec(N - 1, sum, coins);

    // long dp[][] = new long[N][sum + 1];
    // for(int i = 0; i < N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(N - 1, sum, coins, dp);

    // return tab(coins, N, sum);

    return so(coins, N, sum);
  }

  public long rec(int i, int v, int coins[]) {

    if (i == 0) {

      if ((v % coins[i]) == 0)
        return 1;
      else
        return 0;

    }

    long not_take = rec(i - 1, v, coins);

    long take = 0;

    if (v >= coins[i]) {
      take = rec(i, v - coins[i], coins);
    }

    return not_take + take;
  }

  public long mem(int i, int v, int coins[], long dp[][]) {

    if (i == 0) {

      if ((v % coins[i]) == 0)
        return 1;
      else
        return 0;

    }

    if (dp[i][v] != -1)
      return dp[i][v];

    long not_take = mem(i - 1, v, coins, dp);

    long take = 0;

    if (v >= coins[i]) {
      take = mem(i, v - coins[i], coins, dp);
    }

    return dp[i][v] = not_take + take;
  }

  public long tab(int coins[], int n, int sum) {

    long dp[][] = new long[n][sum + 1];

    for (int v = 0; v <= sum; v++) {
      if ((v % coins[0]) == 0)
        dp[0][v] = 1;
      else
        dp[0][v] = 0;
    }

    for (int i = 1; i < n; i++) {
      for (int v = 0; v <= sum; v++) {

        long not_take = dp[i - 1][v];

        long take = 0;

        if (v >= coins[i]) {
          take = dp[i][v - coins[i]];
        }

        dp[i][v] = not_take + take;

      }
    }

    return dp[n - 1][sum];
  }

  public long so(int coins[], int n, int sum) {

    long prev[] = new long[sum + 1];

    for (int v = 0; v <= sum; v++) {
      if ((v % coins[0]) == 0)
        prev[v] = 1;
      else
        prev[v] = 0;
    }

    for (int i = 1; i < n; i++) {
      long curr[] = new long[sum + 1];

      for (int v = 0; v <= sum; v++) {

        long not_take = prev[v];

        long take = 0;

        if (v >= coins[i]) {
          take = curr[v - coins[i]];
        }

        curr[v] = not_take + take;

      }
      prev = curr;
    }

    return prev[sum];
  }

  public long so2(int coins[], int N, int sum) {
    long states[] = new long[sum + 1];
    states[0] = 1l;

    for (int denom = 0; denom < N; denom++) {
      for (int s = coins[denom]; s <= sum; s++) {
        states[s] = states[s - coins[denom]] + states[s];
      }
    }

    return states[sum];

  }
}

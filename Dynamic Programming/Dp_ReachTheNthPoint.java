public class Dp_ReachTheNthPoint {
  public int nthPoint(int n) {
    if (n == 1)
      return 1;

    if (n == 2)
      return 2;

    int mod = 1_000_000_000 + 7;

    int prev1 = 1;
    int prev2 = 2;

    int curr = 0;

    for (int i = 2; i < n; i++) {
      curr = (prev1 % mod + prev2 % mod) % mod;
      prev1 = prev2;
      prev2 = curr;
    }

    return curr;
  }

  public int nthPointdp(int n) {
    if (n == 1)
      return 1;

    if (n == 2)
      return 2;

    int mod = 1_000_000_000 + 7;

    int dp[] = new int[n];
    dp[0] = 1;
    dp[1] = 2;

    for (int i = 2; i < n; i++) {
      dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
    }

    return dp[n - 1] % mod;
  }
}

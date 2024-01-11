public class Dp_CountWaysToNthStair2 {
  // This is fibonacci series
  int countWays(int n) {
    if (n == 0)
      return 1;

    if (n == 1)
      return 1;

    int mod = 1_000_000_000 + 7;

    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
    }

    return dp[n] % mod;
  }
}

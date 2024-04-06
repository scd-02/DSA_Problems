public class Dp_CountWaysToNthStair {
  Long countWays(int n) {

    if (n == 1)
      return 1l;
    if (n == 2)
      return 2l;

    long dp[] = new long[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = 1 + Math.min(dp[i - 1], dp[i - 2]);
    }

    return dp[n];
  }
}

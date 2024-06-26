public class Dp_CountWaysToNthStair1 {

  public long nthStair(int n) {
    if (n == 0)
      return 1;

    if (n == 1)
      return 1;

    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 2] + 1;
    }

    return dp[n];
  }
}
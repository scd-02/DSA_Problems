public class Dp_CatalanNumber {
  public static int findCatalan(int n) {

    long mod = 1000_000_000 + 7;

    int dp[] = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      long ans = 0;
      for (int k = 0; k < i; k++) {
        long first = (long) dp[k] % mod;
        long second = (long) dp[i - k - 1] % mod;
        long mul = (first * second) % mod;
        ans = (ans % mod + mul % mod) % mod;
      }

      dp[i] = (int) ans;
    }

    return dp[n];
  }
}

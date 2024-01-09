import java.util.Arrays;

public class Dp_NoOfDistinctSubsequences {
  int distinctSubsequences(String s) {
    int mod = 1000_000_000 + 7;

    int lastOccIndex[] = new int[26];

    Arrays.fill(lastOccIndex, -1);

    int n = s.length();

    int dp[] = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i < dp.length; i++) {

      dp[i] = (2 * dp[i - 1]);
      dp[i] = dp[i] % mod;

      int ch = (int) s.charAt(i - 1) - 'a';

      if (lastOccIndex[ch] != -1) {
        dp[i] = (dp[i] - dp[lastOccIndex[ch]] + mod) % mod;
      }

      lastOccIndex[ch] = (i - 1);
    }

    return dp[n];
  }
}

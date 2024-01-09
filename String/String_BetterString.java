import java.util.Arrays;

public class String_BetterString {
  public static String betterString(String str1, String str2) {

    int subseq1 = findDistinctSubseq(str1, str1.length());
    int subseq2 = findDistinctSubseq(str2, str2.length());

    return (subseq1 >= subseq2) ? str1 : str2;

  }

  public static int findDistinctSubseq(String s, int n) {

    int dp[] = new int[n + 1];
    dp[0] = 1;

    int prev[] = new int[256];
    Arrays.fill(prev, -1);

    for (int i = 1; i <= n; i++) {

      dp[i] = 2 * dp[i - 1];

      if (prev[s.charAt(i - 1)] != -1) {
        dp[i] = dp[i] - dp[prev[(int) s.charAt(i - 1)]];
      }

      prev[(int) s.charAt(i - 1)] = i - 1;
    }

    return dp[n];
  }
}

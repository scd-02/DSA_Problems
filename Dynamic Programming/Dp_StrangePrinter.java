@SuppressWarnings("unused")
public class Dp_StrangePrinter {

  public int strangePrinter(String s) {

    s = removeDuplicates(s);
    int n = s.length();

    // Integer[][] dp = new Integer[n][n];

    // return mem(0, n - 1, s, dp);

    return tab(s, n);
  }

  private int mem(int start, int end, String s, Integer[][] dp) {

    if (start > end)
      return 0;

    if (dp[start][end] != null)
      return dp[start][end];

    int minTurns = 1 + mem(start + 1, end, s, dp);

    for (int k = start + 1; k <= end; k++) {

      if (s.charAt(k) == s.charAt(start)) {
        int turnsWithMatch = mem(start, k - 1, s, dp) + mem(k + 1, end, s, dp);
        minTurns = Math.min(minTurns, turnsWithMatch);
      }

    }

    return dp[start][end] = minTurns;
  }

  private int tab(String s, int n) {

    int dp[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    for (int length = 2; length <= n; length++) {

      for (int start = 0; start + length - 1 < n; start++) {
        int end = start + length - 1;

        dp[start][end] = length;
        for (int split = 0; split < length - 1; split++) {
          int totalTurns = dp[start][start + split] + dp[start + split + 1][end];

          if (s.charAt(start + split) == s.charAt(end))
            totalTurns--;

          dp[start][end] = Math.min(dp[start][end], totalTurns);
        }
      }
    }

    return dp[0][n - 1];
  }

  private String removeDuplicates(String s) {

    StringBuilder str = new StringBuilder();

    int i = 0;
    while (i < s.length()) {
      char currChar = s.charAt(i);
      str.append(currChar);

      while (i < s.length() && s.charAt(i) == currChar) {
        i++;
      }
    }

    return str.toString();
  }
}

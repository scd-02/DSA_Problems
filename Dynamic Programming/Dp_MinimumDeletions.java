public class Dp_MinimumDeletions {
  /*
   * Given a string of S as input. Your task is to write a program to delete the
   * minimum number of characters from the string so that the resultant string is
   * a palindrome.
   * Note: The order of characters in the string should be maintained.
   */
  static int minimumNumberOfDeletions(String S) {

    int n = S.length();

    String r = reverse(S);

    int dp[][] = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (S.charAt(i - 1) == r.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return n - dp[n][n];
  }

  static String reverse(String s) {
    String r = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      r += s.charAt(i);
    }
    return r;
  }
}

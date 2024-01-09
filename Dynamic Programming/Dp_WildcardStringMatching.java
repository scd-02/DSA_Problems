public class Dp_WildcardStringMatching {

  static boolean isAllStars(String S1, int i) {
    for (int j = 1; j <= i; j++) {
      if (S1.charAt(j - 1) != '*')
        return false;
    }
    return true;
  }

  static boolean match(String wild, String pattern) {

    int n = wild.length();
    int m = pattern.length();

    boolean dp[][] = new boolean[n + 1][m + 1];
    dp[0][0] = true;

    for (int j = 1; j <= m; j++) {
      dp[0][j] = false;
    }

    for (int i = 1; i <= n; i++) {
      dp[i][0] = isAllStars(wild, i);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (wild.charAt(i - 1) == pattern.charAt(j - 1) || wild.charAt(i - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (wild.charAt(i - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[n][m];
  }

  static boolean solveRec(int i, int j, String wild, String pattern) {

    // base case
    if (i < 0 && j < 0)
      return true;

    if (i < 0 && j >= 0)
      return false;

    if (i >= 0 && j < 0) {
      for (int k = 0; k <= i; k++) {
        if (wild.charAt(k) != '*')
          return false;
      }

      return true;
    }

    // recursion
    if (wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?') {
      return solveRec(i - 1, j - 1, wild, pattern);
    }

    if (wild.charAt(i) == '*') {
      return solveRec(i - 1, j, wild, pattern) || solveRec(i, j - 1, wild, pattern);
    }

    return false;
  }

  static boolean matchRecMyThought(String wild, String pattern) {
    int i, j;
    for (i = 0, j = 0; i < pattern.length(); i++, j++) {

      char p = pattern.charAt(i);
      char w = j < wild.length() ? wild.charAt(j) : '#';

      if (w == '#') {

        return false;

      } else if (p != w) {

        if (w == '?') {

          String temp = wild.substring(0, j) + p + wild.substring(j + 1,
              wild.length());
          wild = temp;

        } else if (w == '*') {

          String temp1 = wild.substring(0, j) + p + wild.substring(j, wild.length());
          String temp2 = wild.substring(0, j) + "" + wild.substring(j + 1,
              wild.length());

          return match(temp1, pattern) || match(temp2, pattern);

        } else {
          return false;
        }

      }

    }

    if (pattern.length() == wild.length()) {
      if (!pattern.equals(wild))
        return false;
    } else {
      for (int k = j; k < wild.length(); k++) {
        if (wild.charAt(k) != '*')
          return false;
      }
    }

    return true;
  }
}

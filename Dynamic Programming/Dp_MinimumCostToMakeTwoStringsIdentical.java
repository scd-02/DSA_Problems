public class Dp_MinimumCostToMakeTwoStringsIdentical {
  public int findMinCost(String x, String y, int costX, int costY) {
    // int n1 = x.length();
    // int n2 = y.length();

    // return rec(x, y, n1 - 1, n2 - 1, costX, costY);
    // int dp[][] = new int[n1][n2];

    // for(int i = 0; i < n1; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(x, y, n1 - 1, n2 - 1, costX, costY, dp);

    return tab(x, y, costX, costY);
  }

  public int rec(String s1, String s2, int i1, int i2, int costX, int costY) {

    if (i1 == 0 && i2 == 0) {
      if (s1.charAt(i1) == s2.charAt(i2)) {
        return 0;
      } else {
        return costX + costY;
      }
    } else if (i1 < 0) {
      return (i2 + 1) * costY;
    } else if (i2 < 0) {
      return (i1 + 1) * costX;
    }

    if (s1.charAt(i1) == s2.charAt(i2))
      return rec(s1, s2, i1 - 1, i2 - 1, costX, costY);

    int del1 = costX + rec(s1, s2, i1 - 1, i2, costX, costY);
    int del2 = costY + rec(s1, s2, i1, i2 - 1, costX, costY);

    return Math.min(del1, del2);
  }

  public int mem(String s1, String s2, int i1, int i2, int costX, int costY, int dp[][]) {

    if (i1 == 0 && i2 == 0) {
      if (s1.charAt(i1) == s2.charAt(i2)) {
        return 0;
      } else {
        return costX + costY;
      }
    } else if (i1 < 0) {
      return (i2 + 1) * costY;
    } else if (i2 < 0) {
      return (i1 + 1) * costX;
    }

    if (dp[i1][i2] != -1)
      return dp[i1][i2];

    if (s1.charAt(i1) == s2.charAt(i2))
      return dp[i1][i2] = mem(s1, s2, i1 - 1, i2 - 1, costX, costY, dp);

    int del1 = costX + mem(s1, s2, i1 - 1, i2, costX, costY, dp);
    int del2 = costY + mem(s1, s2, i1, i2 - 1, costX, costY, dp);

    return dp[i1][i2] = Math.min(del1, del2);

  }

  public int tab(String s1, String s2, int costX, int costY) {

    int n1 = s1.length();
    int n2 = s2.length();

    int dp[][] = new int[n1 + 1][n2 + 1];

    for (int i1 = 0; i1 <= n1; i1++) {
      dp[i1][0] = i1 * costX;
    }

    for (int i2 = 0; i2 <= n2; i2++) {
      dp[0][i2] = i2 * costY;
    }

    for (int i1 = 1; i1 <= n1; i1++) {
      for (int i2 = 1; i2 <= n2; i2++) {

        if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
          dp[i1][i2] = dp[i1 - 1][i2 - 1];
        } else {
          int del1 = costX + dp[i1 - 1][i2];
          int del2 = costY + dp[i1][i2 - 1];

          dp[i1][i2] = Math.min(del1, del2);
        }

      }
    }

    return dp[n1][n2];
  }
}

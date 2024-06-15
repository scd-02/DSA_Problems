import java.util.Arrays;

public class Dp_MobileNumericKeypad {

  class DpSolution {

    int row[] = { 0, -1, 0, 1, 0 };
    int col[] = { 0, 0, 1, 0, -1 };

    public long getCount(int n) {
      int keypad[][] = {
          { 1, 2, 3 },
          { 4, 5, 6 },
          { 7, 8, 9 },
          { -1, 0, -1 }
      };

      if (n == 1)
        return 10;

      long totalCount = 0;
      long dp[][][] = new long[keypad.length][keypad[0].length][n + 1];
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[i].length; j++) {
          Arrays.fill(dp[i][j], -1);
        }
      }

      for (int i = 0; i < keypad.length; i++) {
        for (int j = 0; j < keypad[0].length; j++) {

          if (keypad[i][j] != -1) {
            // totalCount += rec(keypad, i, j, n);
            totalCount += mem(keypad, i, j, n, dp);
          }
        }
      }

      return totalCount;
    }

    long rec(int[][] keypad, int i, int j, int n) {

      if (n <= 0)
        return 0;

      if (n == 1)
        return 1;

      long totalCount = 0;

      for (int move = 0; move < 5; move++) {
        int newRow = i + row[move];
        int newCol = j + col[move];

        if (newRow >= 0 && newRow < keypad.length && newCol >= 0 && newCol < keypad[0].length
            && keypad[newRow][newCol] != -1) {
          totalCount += rec(keypad, newRow, newCol, n - 1);
        }
      }

      return totalCount;
    }

    long mem(int[][] keypad, int i, int j, int n, long dp[][][]) {

      if (n <= 0)
        return 0;

      if (n == 1)
        return 1;

      if (dp[i][j][n] != -1)
        return dp[i][j][n];

      long totalCount = 0;

      for (int move = 0; move < 5; move++) {
        int newRow = i + row[move];
        int newCol = j + col[move];

        if (newRow >= 0 && newRow < keypad.length && newCol >= 0 && newCol < keypad[0].length
            && keypad[newRow][newCol] != -1) {
          totalCount += mem(keypad, newRow, newCol, n - 1, dp);
        }
      }

      return dp[i][j][n] = totalCount;
    }
  }

  class OptimalSolution {
    public long getCount(int n) {

      int adj[][] = {
          { 0, 8 },
          { 1, 2, 4 },
          { 1, 2, 3, 5 },
          { 2, 3, 6 },
          { 1, 4, 5, 7 },
          { 2, 4, 5, 6, 8 },
          { 3, 5, 6, 9 },
          { 4, 7, 8 },
          { 5, 7, 8, 9, 0 },
          { 6, 8, 9 }
      };

      long dp[][] = new long[n + 1][10];

      for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 10; j++) {

          if (i == 1)
            dp[i][j] = 1;

          else {
            for (int adjNo : adj[j]) {
              dp[i][j] += dp[i - 1][adjNo];
            }
          }
        }
      }

      long totalCount = 0;

      for (int i = 0; i < 10; i++) {
        totalCount += dp[n][i];
      }

      return totalCount;
    }
  }
}

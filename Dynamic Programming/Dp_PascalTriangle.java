import java.util.ArrayList;

public class Dp_PascalTriangle {
  ArrayList<Long> nthRowOfPascalTriangle(int n) {
    long mod = 1_000_000_000 + 7;

    long dp[][] = new long[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {

        if (j == 0) {
          dp[i][j] = 1;
          continue;
        }

        if (i == j) {
          dp[i][j] = 1;
          continue;
        }

        dp[i][j] = (dp[i - 1][j - 1] % mod + dp[i - 1][j] % mod) % mod;

      }
    }

    ArrayList<Long> ans = new ArrayList<>();

    for (int j = 0; j < n; j++) {
      ans.add(dp[n - 1][j]);
    }

    return ans;
  }
}

public class Dp_MinimumSumPartition {
  public int minDifference(int a[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
    }

    boolean dp[][] = new boolean[n][sum + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    if (a[0] <= sum) {
      dp[0][a[0]] = true;
    }

    for (int i = 1; i < n; i++) {
      for (int target = 1; target <= sum; target++) {
        boolean not_take = dp[i - 1][target];

        boolean take = false;
        if (target >= a[i]) {
          take = dp[i - 1][target - a[i]];
        }

        dp[i][target] = take | not_take;
      }
    }

    int ans = (int) 1e9;
    for (int j = 0; j <= sum / 2; j++) {

      if (dp[n - 1][j]) {
        int s1 = j;
        int s2 = sum - s1;

        ans = Math.min(ans, Math.abs(s1 - s2));
      }

    }

    return ans;
  }
}

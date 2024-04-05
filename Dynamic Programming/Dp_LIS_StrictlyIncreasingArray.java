import java.util.Arrays;

public class Dp_LIS_StrictlyIncreasingArray {
  public int min_operations(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp, 1);

    int LIS = 1;
    for (int i = 1; i < n; i++) {
      for (int prev = 0; prev < i; prev++) {

        if ((nums[prev] < nums[i]) && ((nums[i] - nums[prev]) >= (i - prev))) {
          dp[i] = Math.max(1 + dp[prev], dp[i]);
        }

      }

      LIS = Math.max(dp[i], LIS);
    }

    return n - LIS;
  }
}

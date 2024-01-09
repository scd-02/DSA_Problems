public class Dp_MaximumSumIncreasingSubsequence {
  public int maxSumIS(int arr[], int n) {

    int dp[] = new int[n];
    dp[0] = arr[0];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = dp[j] + arr[i] > dp[i] ? dp[j] + arr[i] : dp[i];
        }
      }
      if (dp[i] == 0)
        dp[i] = arr[i];
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(dp[i], max);
    }

    return max;
  }
}

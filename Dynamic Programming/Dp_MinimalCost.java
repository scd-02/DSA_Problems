public class Dp_MinimalCost {
  public int minimizeCost(int k, int arr[]) {
    int n = arr.length;

    int dp[] = new int[n];

    for (int i = 1; i < n; i++) {
      dp[i] = Integer.MAX_VALUE;

      for (int j = 1; j <= k; j++) {

        int jump = i - j;
        if (jump >= 0) {
          dp[i] = Math.min(dp[i], dp[jump] + Math.abs(arr[i] - arr[jump]));
        }

      }
    }

    return dp[n - 1];
  }

}

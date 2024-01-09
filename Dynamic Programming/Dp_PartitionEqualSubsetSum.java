
public class Dp_PartitionEqualSubsetSum {
  static int equalPartition(int N, int arr[]) {
    int totalSum = 0;
    for (int e : arr) {
      totalSum += e;
    }

    if (totalSum % 2 != 0)
      return 0;

    boolean dp[][] = new boolean[N + 1][totalSum + 1];

    for (int j = 0; j <= N; j++) {
      dp[j][0] = true;
    }

    int k = totalSum / 2;

    for (int i = 1; i <= N; i++) {
      for (int sum = 0; sum <= k; sum++) {

        if (arr[i - 1] <= sum) {
          dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - arr[i - 1]];
        } else {
          dp[i][sum] = dp[i - 1][sum];
        }

      }
    }

    return dp[N][k] == true ? 1 : 0;
  }

}

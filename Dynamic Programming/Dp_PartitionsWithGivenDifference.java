public class Dp_PartitionsWithGivenDifference {
  int mod = 1_000_000_000 + 7;

  public int countPartitions(int n, int d, int arr[]) {

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    if ((sum - d) < 0 || (sum - d) % 2 != 0)
      return 0;

    // return rec(n - 1, (sum - d) / 2, arr);

    // int dp[][] = new int[n][sum - d + 1];
    // for(int i = 0; i < n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(n - 1, (sum - d) / 2, arr, dp);

    return tab(n, arr, (sum - d) / 2);
  }

  int rec(int i, int target, int arr[]) {

    if (i == 0) {

      if (target == 0 && arr[0] == 0)
        return 2;

      if (target == 0 || target == arr[i])
        return 1;

      return 0;
    }

    int not_take = rec(i - 1, target, arr);

    int take = 0;
    if (target >= arr[i]) {
      take = rec(i - 1, target - arr[i], arr);
    }

    return (take % mod + not_take % mod) % mod;
  }

  int mem(int i, int target, int arr[], int dp[][]) {

    if (i == 0) {

      if (target == 0 && arr[0] == 0)
        return 2;

      if (target == 0 || target == arr[i])
        return 1;

      return 0;
    }

    if (dp[i][target] != -1)
      return dp[i][target];

    int not_take = mem(i - 1, target, arr, dp);

    int take = 0;
    if (target >= arr[i]) {
      take = mem(i - 1, target - arr[i], arr, dp);
    }

    return dp[i][target] = (take % mod + not_take % mod) % mod;
  }

  int tab(int n, int arr[], int sum) {

    int dp[][] = new int[n][sum + 1];

    if (arr[0] == 0)
      dp[0][0] = 2;
    else
      dp[0][0] = 1;

    if (arr[0] != 0 && arr[0] <= sum)
      dp[0][arr[0]] = 1;

    for (int i = 1; i < n; i++) {
      for (int target = 0; target <= sum; target++) {
        int not_take = dp[i - 1][target];

        int take = 0;
        if (target >= arr[i]) {
          take = dp[i - 1][target - arr[i]];
        }

        dp[i][target] = (take % mod + not_take % mod) % mod;
      }
    }

    return dp[n - 1][sum];
  }
}

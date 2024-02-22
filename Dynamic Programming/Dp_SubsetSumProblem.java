public class Dp_SubsetSumProblem {
  static Boolean isSubsetSum(int N, int arr[], int sum) {

    // return rec(N - 1, sum, arr);

    // int dp[][] = new int[N + 1][sum + 1];
    // for(int i = 0; i < N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(N - 1, sum, arr, dp) == 1 ? true : false;

    return tab(arr, sum, N);
  }

  static boolean tab(int a[], int sum, int n) {

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

    return dp[n - 1][sum];
  }

  static int mem(int i, int target, int arr[], int dp[][]) {

    if (target == 0)
      return 1;

    if (i == 0)
      return arr[i] == target ? 1 : 0;

    int not_take = mem(i - 1, target, arr, dp);
    int take = 0;

    if (target >= arr[i]) {
      take = mem(i - 1, target - arr[i], arr, dp);
    }

    return (not_take == 1 || take == 1) ? 1 : 0;

  }

  static boolean rec(int i, int target, int arr[]) {

    if (target == 0)
      return true;

    if (i == 0)
      return arr[i] == target;

    boolean not_take = rec(i - 1, target, arr);
    boolean take = false;

    if (target >= arr[i]) {
      take = rec(i - 1, target - arr[i], arr);
    }

    return not_take || take;
  }
}

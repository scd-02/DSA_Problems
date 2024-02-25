import java.util.Arrays;

public class Dp_ReachAGivenScore {
  public long count(int n) {

    int arr[] = { 3, 5, 10 };
    // return rec(n, 0, arr);

    // long dp[][] = new long[n + 1][3];
    // for(int i = 0; i <= n; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(n, 0, arr, dp);

    // return tab(n, arr);

    return so(n, arr);
  }

  public long rec(int n, int i, int arr[]) {

    if (n < 0 || i == arr.length)
      return 0;

    if (n == 0)
      return 1l;

    long not_take = rec(n, i + 1, arr);
    long take = rec(n - arr[i], i, arr);

    return take + not_take;

  }

  public long mem(int n, int i, int arr[], long dp[][]) {

    if (n < 0 || i == arr.length)
      return 0;

    if (n == 0)
      return 1l;

    if (dp[n][i] != -1)
      return dp[n][i];

    long not_take = mem(n, i + 1, arr, dp);
    long take = mem(n - arr[i], i, arr, dp);

    return dp[n][i] = take + not_take;
  }

  public long tab(int num, int arr[]) {
    int size = arr.length;
    long dp[][] = new long[num + 1][size];

    Arrays.fill(dp[0], 1);

    for (int n = 1; n <= num; n++) {
      for (int i = size - 1; i >= 0; i--) {

        long take = 0;
        if (n - arr[i] >= 0) {
          take = dp[n - arr[i]][i];
        }

        long not_take = 0;
        if (i + 1 < size) {
          not_take = dp[n][i + 1];
        }

        dp[n][i] = take + not_take;
      }
    }

    return dp[num][0];
  }

  public long so(int num, int arr[]) {

    long dp[] = new long[num + 1];
    dp[0] = 1l;

    for (int move : arr) {
      for (int i = move; i <= num; i++) {
        dp[i] += dp[i - move];
      }
    }

    return dp[num];
  }
}

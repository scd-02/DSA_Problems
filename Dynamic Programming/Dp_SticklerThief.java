import java.util.Arrays;

public class Dp_SticklerThief {
  public static int FindMaxSum(int arr[], int n) {

    if (n == 1)
      return arr[0];
    if (n == 2)
      return Math.max(arr[0], arr[1]);
    if (n == 3)
      return Math.max(arr[1], arr[0] + arr[2]);

    int dp[] = new int[n];
    dp[0] = arr[0];
    dp[1] = arr[1];
    dp[2] = arr[0] + arr[2];

    for (int i = 3; i < n; i++) {
      dp[i] = arr[i] + Math.max(dp[i - 3], dp[i - 2]);
    }
    System.out.println(Arrays.toString(dp));
    return Math.max(dp[n - 1], dp[n - 2]);
  }

  public static void main(String[] args) {
    int a[] = { 5, 5, 10, 100, 10, 5 };
    System.out.println(FindMaxSum(a, 6));
  }

  public int maxSumRec(int arr[], int i, int n) {

    if (i >= n)
      return 0;

    if (n == 0)
      return arr[0];

    int include = maxSumRec(arr, i + 2, n) + arr[i];
    int exclude = maxSumRec(arr, i + 1, n) + 0;

    return Math.max(include, exclude);

  }

  int maxSumMemo(int arr[], int i, int n, int dp[]) {

    if (i >= n)
      return 0;

    if (n == 0) {
      dp[0] = arr[0];
      return dp[0];
    }

    if (dp[i] != 0) {
      return dp[i];
    }

    int include = maxSumMemo(arr, i + 2, n, dp) + arr[i];
    int exclude = maxSumMemo(arr, i + 1, n, dp) + 0;

    dp[i] = Math.max(include, exclude);

    return dp[i];
  }
}

public class Array_MinimizeTheDifference {
  public static int minimizeDifference(int n, int k, int[] arr) {

    // preprocessing to calculate the right hand side max and min from window of
    // size k
    int rightMax[] = new int[n];
    int rightMin[] = new int[n];

    rightMax[n - 1] = rightMin[n - 1] = arr[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
      rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
    }

    // for 1st window
    int ans = rightMax[k] - rightMin[k];

    // from 2nd window to last 2nd window
    int leftMax = arr[0], leftMin = arr[0];

    for (int i = 1; i < n - k; i++) {
      int max = Math.max(leftMax, rightMax[i + k]);
      int min = Math.min(leftMin, rightMin[i + k]);

      ans = Math.min(ans, max - min);

      leftMax = Math.max(leftMax, arr[i]);
      leftMin = Math.min(leftMin, arr[i]);
    }

    // for last window
    ans = Math.min(ans, leftMax - leftMin);

    return ans;

  }
}

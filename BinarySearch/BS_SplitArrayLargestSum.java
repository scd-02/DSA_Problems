public class BS_SplitArrayLargestSum {
  static int splitArray(int[] arr, int N, int K) {

    if (K > N)
      return -1;

    int low = arr[0], high = 0;

    for (int i = 0; i < N; i++) {
      low = Math.max(low, arr[i]);
      high += arr[i];
    }

    while (low <= high) {

      int mid = (low + high) / 2;

      int countSplits = split(arr, mid);

      if (countSplits > K) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }

    }

    return low;
  }

  static int split(int arr[], int maxSum) {
    int cut = 1;
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {

      if (sum + arr[i] <= maxSum) {
        sum += arr[i];
      } else {
        cut++;
        sum = arr[i];
      }

    }

    return cut;
  }
}

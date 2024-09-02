public class Bs_FindTheStudentThatWillReplaceTheChalk {

  public int chalkReplacer(int[] chalk, int k) {

    int n = chalk.length;

    long prefixSum[] = new long[n];
    prefixSum[0] = chalk[0];

    for (int i = 1; i < chalk.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + chalk[i];
    }

    long remainingChalk = k % prefixSum[n - 1];

    return binarySearch(prefixSum, remainingChalk);
  }

  private int binarySearch(long[] arr, long val) {
    int low = 0, high = arr.length - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] <= val) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return high;
  }
}
import java.util.ArrayList;

public class Array_SW_MaxSumSubarrayOfSizeK {
  static long maximumSumSubarray(int k, ArrayList<Integer> arr, int n) {

    long sum = 0;
    int start = 0;
    long max = Long.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      sum += arr.get(i);

      if ((i - start + 1) == k) {

        max = Math.max(max, sum);
        sum -= arr.get(start);
        start++;
      }
    }

    return max;
  }
}

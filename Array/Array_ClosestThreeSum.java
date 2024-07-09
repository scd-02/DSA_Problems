import java.util.Arrays;

public class Array_ClosestThreeSum {
  static int threeSumClosest(int[] arr, int target) {

    Arrays.sort(arr);
    int ans = 0;
    int minDiff = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {

      int start = i + 1, end = arr.length - 1;

      while (start < end) {

        int currSum = arr[i] + arr[start] + arr[end];
        int diff = Math.abs(target - currSum);

        if (diff == 0) {
          return currSum;
        } else if (currSum > target) {

          if (diff < minDiff) {
            minDiff = diff;
            ans = currSum;
          } else if (diff == minDiff) {
            ans = Math.max(ans, currSum);
          }

          end--;

        } else {

          if (diff < minDiff) {
            minDiff = diff;
            ans = currSum;
          } else if (diff == minDiff) {
            ans = Math.max(ans, currSum);
          }

          start++;

        }

      }

    }

    return ans;

  }
}

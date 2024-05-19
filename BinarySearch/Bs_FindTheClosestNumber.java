public class Bs_FindTheClosestNumber {
  class Solution {
    public static int findClosest(int n, int k, int[] arr) {

      int l = 0, h = n - 1;
      int nearest = Integer.MAX_VALUE;

      int res = 0;

      while (l <= h) {

        int mid = (l + h) / 2;
        int diff = Math.abs(arr[mid] - k);

        if (diff == 0) {
          return arr[mid];
        } else if (diff < nearest) {
          nearest = diff;
          res = arr[mid];
        } else if (diff == nearest) {
          res = Math.max(res, arr[mid]);
        }

        if (arr[mid] < k)
          l = mid + 1;
        else
          h = mid - 1;
      }

      return res;
    }
  }
}

import java.util.Arrays;

public class Array_PythagoreanTriplet {
  /*
   * Given an array arr of n integers, write a function that returns true if there
   * is a triplet (a, b, c) from the array (where a, b, and c are on different
   * indexes) that satisfies a^2 + b^2 = c^2, otherwise return false.
   */
  boolean checkTriplet(int[] arr, int n) {
    Arrays.sort(arr);

    for (int i = 2; i < n; i++) {

      int s = 0;
      int e = i - 1;

      while (s < e) {
        if (Math.pow(arr[s], 2) + Math.pow(arr[e], 2) == Math.pow(arr[i], 2)) {
          return true;
        } else if (Math.pow(arr[s], 2) + Math.pow(arr[e], 2) < Math.pow(arr[i], 2)) {
          s++;
        } else {
          e--;
        }
      }
    }

    return false;
  }
}

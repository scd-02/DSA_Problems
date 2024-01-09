public class Array_NoOfSubArraysWithMaxValuesInGivenRange {
  static long countSubarrays(int a[], int n, int L, int R) {

    int start = -1;
    int end = -1;

    long count = 0;

    for (int i = 0; i < n; i++) {

      // if element > R discard the whole subarray form and start from here
      if (a[i] > R) {
        start = end = i;
        continue;
      }

      // if element < L then we can't form subarray but if element >= L and <= R we
      // can form subarray
      if (a[i] >= L) {
        end = i;
      }

      // to form subarray we do (end - start)
      count += (end - start);

    }

    return count;
  }
}

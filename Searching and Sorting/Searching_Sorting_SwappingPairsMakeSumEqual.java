import java.util.Arrays;

public class Searching_Sorting_SwappingPairsMakeSumEqual {
  long findSwapValues(long a[], int n, long b[], int m) {

    long sum1 = 0;
    for (long ele : a) {
      sum1 += ele;
    }

    long sum2 = 0;
    for (long ele : b) {
      sum2 += ele;
    }

    if ((sum1 + sum2) % 2 != 0)
      return -1;

    long diff = (sum1 - sum2) / 2;

    Arrays.sort(b);

    for (int i = 0; i < n; i++) {
      long pairDiff = a[i] - diff;

      if (binarySearch(b, pairDiff)) {
        return 1;
      }
    }

    return -1;
  }

  boolean binarySearch(long a[], long key) {

    int s = 0, e = a.length - 1;
    while (s <= e) {
      int mid = (s + e) / 2;

      if (a[mid] == key)
        return true;
      else if (a[mid] < key)
        s = mid + 1;
      else
        e = mid - 1;
    }

    return false;
  }
}

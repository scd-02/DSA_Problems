public class Bs_KthElementOfTwoSortedArrays {
  public long kthElement(int arr1[], int arr2[], int n, int m, int k) {

    if (n > m)
      return kthElement(arr2, arr1, m, n, k);

    int leftPortion = k;

    int low = Math.max(0, k - m), high = Math.min(k, n);

    while (low <= high) {

      int mid1 = (low + high) / 2;
      int mid2 = leftPortion - mid1;

      long l1 = mid1 - 1 >= 0 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
      long l2 = mid2 - 1 >= 0 ? arr2[mid2 - 1] : Integer.MIN_VALUE;
      long r1 = mid1 < n ? arr1[mid1] : Integer.MAX_VALUE;
      long r2 = mid2 < m ? arr2[mid2] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1)
        return Math.max(l1, l2);
      else if (l1 > r2)
        high = mid1 - 1;
      else
        low = mid1 + 1;
    }

    return 0;
  }
}

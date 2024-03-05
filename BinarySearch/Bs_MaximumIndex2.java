public class Bs_MaximumIndex2 {
  int maxIndexDiff(int arr[], int n) {

    int maxFromEnd[] = new int[n + 1];
    maxFromEnd[n] = Integer.MIN_VALUE;

    for (int i = n - 1; i >= 0; i--) {
      maxFromEnd[i] = Math.max(maxFromEnd[i + 1], arr[i]);
    }

    int res = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      int s = i;
      int e = n - 1;

      while (s <= e) {

        int mid = (s + e) / 2;

        if (arr[i] <= maxFromEnd[mid]) {
          res = Math.max(res, mid - i);
          s = mid + 1;
        } else {
          e = mid - 1;
        }

      }

    }
    return res;
  }
}

public class Bs_KClosestElements {
  int[] printKClosest(int[] arr, int n, int k, int x) {

    int low = 0, high = n - 1;

    while (low < high) {

      int mid = (low + high) / 2;

      if (arr[mid] < x) {
        low = mid + 1;
      } else {
        high = mid;
      }

    }

    int left = low - 1;
    int right = (low < n && arr[low] != x) ? low : low + 1;

    int ans[] = new int[k];

    for (int i = 0; i < k; i++) {

      if (left >= 0 && right < n) {
        ans[i] = arr[right] - x <= x - arr[left] ? arr[right++] : arr[left--];
      } else if (left >= 0) {
        ans[i] = arr[left--];
      } else {
        ans[i] = arr[right++];
      }

    }

    return ans;
  }
}

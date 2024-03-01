public class BS_PeakElement {
  public int peakElement(int[] arr, int n) {
    if (n == 1)
      return 0;

    int s = 0, e = n - 1;

    while (s < e) {

      int mid = (s + e) / 2;

      if (arr[mid] >= arr[mid + 1]) {
        e = mid;
      } else {
        s = mid + 1;
      }
    }

    return s;
  }
}

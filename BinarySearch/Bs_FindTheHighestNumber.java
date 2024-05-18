import java.util.List;

public class Bs_FindTheHighestNumber {
  public int findPeakElement(List<Integer> arr) {

    int n = arr.size();
    int l = 0, r = n - 1;

    while (l < r) {

      int mid = (l + r) / 2;

      if (arr.get(mid) < arr.get(mid + 1)) {
        l = mid + 1;
      } else {
        r = mid;
      }

    }
    return arr.get(l);
  }

  public int findPeakElement2(List<Integer> arr) {

    int n = arr.size();
    int l = 0, r = n - 1;

    while (l <= r) {

      int mid = (l + r) / 2;

      if (mid - 1 >= 0 && mid + 1 < n && arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
        return arr.get(mid);
      } else if (mid + 1 < n && arr.get(mid) < arr.get(mid + 1)) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }

    }
    return arr.get(n - 1);
  }
}

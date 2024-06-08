public class Bs_IndexOfAnExtraElement {
  public int findExtra(int n, int arr1[], int arr2[]) {

    int low = 0, high = n - 2;
    while (low <= high) {

      int mid = (low + high) / 2;
      if (arr1[mid + 1] == arr2[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }

    }

    return low;
  }
}

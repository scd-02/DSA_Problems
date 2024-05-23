public class Bs_SearchInRotatedSortedArray2 {

  public static boolean Search(int n, int[] arr, int key) {

    int low = 0, high = n - 1;

    while (low <= high) {

      int mid = (low + high) / 2;

      if (arr[mid] == key) {
        return true;
      } else if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
        low++;
        high--;
      } else if (arr[low] <= arr[mid]) {
        if (arr[low] <= key && key <= arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (arr[mid] <= key && key <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }

    }

    return false;
  }
}
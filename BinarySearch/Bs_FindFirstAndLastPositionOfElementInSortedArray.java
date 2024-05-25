public class Bs_FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] arr, int target) {

    int ans[] = new int[2];
    ans[0] = firstIndex(arr, target);
    ans[1] = lastIndex(arr, target);

    return ans;
  }

  public int firstIndex(int arr[], int target) {

    int l = 0, h = arr.length - 1;
    int index = -1;

    while (l <= h) {
      int mid = (l + h) / 2;

      if (arr[mid] == target) {
        index = mid;
        h = mid - 1;
      } else if (arr[mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return index;
  }

  public int lastIndex(int arr[], int target) {

    int l = 0, h = arr.length - 1;
    int index = -1;

    while (l <= h) {
      int mid = (l + h) / 2;

      if (arr[mid] == target) {
        index = mid;
        l = mid + 1;
      } else if (arr[mid] < target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return index;
  }
}

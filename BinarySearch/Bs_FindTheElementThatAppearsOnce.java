public class Bs_FindTheElementThatAppearsOnce {
  public static int search(int arr[], int n) {
    if (n == 1)
      return arr[0];
    if (arr[0] != arr[1])
      return arr[0];
    if (arr[n - 1] != arr[n - 2])
      return arr[n - 1];

    int low = 0, high = n - 1;
    while (low <= high) {

      int mid = (low + high) / 2;

      if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
        return arr[mid];
      } else if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
          (mid % 2 != 0 && arr[mid] == arr[mid - 1])) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }

    }

    return -1;
  }
}

public class Array_NoOfOccurence {
  int count(int[] arr, int n, int x) {

    int left = leftBS(arr, x);
    int right = rightBS(arr, x);

    return (left == -1 && right == -1) ? 0 : (right - left + 1);
  }

  static int leftBS(int arr[], int x) {

    int s = 0;
    int e = arr.length - 1;
    int index = -1;

    while (s <= e) {
      int mid = (s + e) / 2;

      if (arr[mid] == x) {
        index = mid;
        e = mid - 1;
      } else if (arr[mid] > x) {
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }

    return index;
  }

  static int rightBS(int arr[], int x) {

    int s = 0;
    int e = arr.length - 1;
    int index = -1;

    while (s <= e) {
      int mid = (s + e) / 2;

      if (arr[mid] == x) {
        index = mid;
        s = mid + 1;
      } else if (arr[mid] < x) {
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }

    return index;
  }
}

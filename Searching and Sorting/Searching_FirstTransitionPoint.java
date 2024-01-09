public class Searching_FirstTransitionPoint {
  int transitionPoint(int arr[], int n) {

    int s = 0;
    int e = n - 1;
    int index = -1;

    while (s <= e) {

      int mid = (s + e) / 2;

      if (arr[mid] == 1) {
        index = mid;
        e = mid - 1;
      } else {
        s = mid + 1;
      }

    }

    return index;
  }
}

import java.util.ArrayList;

public class Searching_FindFirstAndLastOccurence {
  ArrayList<Integer> find(int arr[], int n, int x) {

    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(leftIndex(arr, n, x));
    ans.add(rightIndex(arr, n, x));

    return ans;
  }

  int leftIndex(int arr[], int n, int x) {

    int s = 0, e = n - 1;
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

  int rightIndex(int arr[], int n, int x) {

    int s = 0, e = n - 1;
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

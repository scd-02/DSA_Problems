import java.util.Arrays;

public class Sorting_NumberOfPairs {
  public long countPairs(int arr[], int brr[], int M, int N) {

    Arrays.sort(brr);

    long count1 = 0, count2 = 0, count34 = 0;

    for (int y : brr) {

      if (y == 1)
        count1++;
      else if (y == 2)
        count2++;
      else if (y == 3 || y == 4)
        count34++;

    }

    long res = 0;

    for (int x : arr) {

      if (x != 1) {
        res += count1;

        if (x == 2)
          res -= count34;
        else if (x == 3)
          res += count2;

        int index = binarySearch(brr, x);
        res += N - index - 1;

      }
    }

    return res;
  }

  private int binarySearch(int arr[], int val) {

    int low = 0, high = arr.length - 1;
    int index = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (arr[mid] <= val) {
        index = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return index;
  }
}

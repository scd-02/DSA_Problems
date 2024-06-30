import java.util.Arrays;

public class Bs_AggressiveCows {

  public static int solve(int n, int k, int[] stalls) {

    Arrays.sort(stalls);

    int low = 1, high = stalls[n - 1] - stalls[0];

    while (low <= high) {
      int mid = (low + high) / 2;

      int cowsCount = placeCows(stalls, n, mid);

      if (cowsCount >= k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return high;
  }

  static int placeCows(int stalls[], int n, int dist) {

    int cowsCount = 1;
    int lastPlaced = stalls[0];

    for (int i = 1; i < n; i++) {

      if (stalls[i] - lastPlaced >= dist) {
        cowsCount++;
        lastPlaced = stalls[i];
      }

    }

    return cowsCount;
  }
}

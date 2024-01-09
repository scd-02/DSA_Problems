import java.util.Arrays;

public class Array_CoinPiles {
  static int minSteps(int[] a, int n, int k) {
    Arrays.sort(a);

    int prev[] = new int[n];

    prev[0] = a[0];
    for (int i = 1; i < n; i++) {
      prev[i] = prev[i - 1] + a[i];
    }

    int ans = Integer.MAX_VALUE;
    int start = 0;

    for (int i = 0; i < n; i++) {

      int index = upperBound(a, a[i] + k, i, n - 1);

      if (index == -1) {
        index = n;
      }

      if (i > 0 && a[i] != a[i - 1])
        start = prev[i - 1];

      ans = Math.min(ans, start + ((prev[n - 1] - prev[index - 1]) - ((n - index) * (a[i] + k))));
    }

    return ans;
  }

  static int upperBound(int a[], int key, int s, int e) {
    int ans = -1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (a[mid] > key) {
        ans = mid;
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }
    return ans;
  }
}

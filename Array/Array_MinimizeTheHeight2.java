import java.util.Arrays;

public class Array_MinimizeTheHeight2 {
  int getMinDiff(int[] arr, int n, int k) {

    Arrays.sort(arr);

    int diff = arr[n - 1] - arr[0];

    int min, max;

    for (int i = 1; i < n; i++) {

      min = Math.min(arr[0] + k, arr[i] - k);
      max = Math.max(arr[i - 1] + k, arr[n - 1] - k);

      if (min < 0)
        continue;

      diff = Math.min(diff, max - min);
    }

    return diff;
  }
}

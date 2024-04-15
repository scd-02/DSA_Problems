import java.util.Arrays;
import java.util.HashMap;

public class Array_CountTheElements {
  public static int[] countElements(int a[], int b[], int n, int query[], int q) {

    int ans[] = new int[q];

    Arrays.sort(b);
    for (int i = 0; i < q; i++) {

      int index = binarySearch(b, a[query[i]]);
      ans[i] = index + 1;

    }

    return ans;
  }

  public static int binarySearch(int arr[], int k) {

    int l = 0, h = arr.length - 1;
    int index = -1;

    while (l <= h) {
      int mid = (l + h) / 2;
      if (arr[mid] <= k) {
        index = mid;
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return index;
  }

  public static int[] countElements2(int a[], int b[], int n, int query[], int q) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    int max = -1;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, a[i]);
      hm.put(b[i], hm.getOrDefault(b[i], 0) + 1);
    }

    int cummulative_freq[] = new int[max + 1];
    int count = 0;
    for (int i = 0; i <= max; i++) {
      count += hm.getOrDefault(i, 0);
      cummulative_freq[i] = count;
    }

    int ans[] = new int[q];

    for (int i = 0; i < q; i++) {
      ans[i] = cummulative_freq[a[query[i]]];
    }

    return ans;
  }
}

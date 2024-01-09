import java.util.Arrays;

public class Array_MaxmizeSumAgterKNegation {
  public static long maximizeSum(long a[], int n, int k) {
    Arrays.sort(a);

    for (int i = 0; i < n; i++) {
      if (a[i] < 0 && k != 0) {
        a[i] = -a[i];
        k--;
      } else
        break;
    }

    Arrays.sort(a);

    long sum = 0l;
    for (int i = 0; i < n; i++)
      sum += a[i];

    if (k != 0 && (k & 1) != 0) {
      sum = sum - 2 * a[0];
    }

    return sum;

  }
}

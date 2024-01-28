import java.util.ArrayList;

public class Bit_GeekinaHates1s {
  public long ncr(int n, int r) {

    long ans = 1;

    for (long i = n; i > Math.max(r, n - r); i--)
      ans *= i;

    long den = 1;

    for (long i = 1; i <= Math.min(r, n - r); i++)
      den *= i;

    ans /= den;

    return ans;
  }

  public long findNthNumer(int n, int k) {

    long dp[][] = new long[64][k + 1];

    for (int i = 0; i < 64; i++) {
      for (int j = 0; j <= k; j++) {
        for (int x = 0; x <= Math.min(i + 1, j); x++) {
          dp[i][j] += ncr(i + 1, x);
        }
      }
    }

    int pos = 0;

    for (int i = 0; i < 64; i++) {
      if (dp[i][k] >= n) {
        pos = i;
        break;
      }
    }

    long ans = 0;

    while (pos > -1 && n > 0) {
      if (pos + 1 <= k) {
        ans += n - 1;
        break;
      }

      if (pos > 0 && dp[pos - 1][k] < n) {
        ans |= (1L << pos);
        n -= dp[pos - 1][k];
        k = Math.max(k - 1, 0);
      }

      --pos;
    }

    return ans;
  }

  public long findNthNumer2(int n, int k) {

    if (n == 1)
      return 0;

    ArrayList<Long> arr = new ArrayList<>();
    arr.add(0l);
    n--;

    int x = 0;
    int index = 1;

    while (true) {

      for (int i = 0; i < (1 << x); i++) {
        arr.add(arr.get(i) + 1);

        if (arr.get(index) <= k) {
          n--;
        }

        if (n == 0) {
          return index;
        }

        index++;
      }
      // System.out.println(arr + " " + n);

      x++;
    }
  }
}

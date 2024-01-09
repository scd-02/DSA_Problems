public class Dp_PaintingTheFence {
  long countWays(int n, int k) {
    if (n == 1)
      return (long) k;

    long mod = 1000_000_000 + 7;

    long same = k * 1;
    long diff = k * (k - 1);

    long total = (same % mod + diff % mod) % mod;

    for (int i = 3; i <= n; i++) {

      same = (diff % mod) * 1;
      diff = ((total % mod) * ((k - 1) % mod)) % mod;
      total = (same + diff) % mod;

    }

    return total;
  }

  long countWaysdp(int n, int k) {
    long mod = 1_000_000_000 + 7;
    long same[] = new long[n];
    long diff[] = new long[n];

    same[0] = 0;
    diff[0] = k;

    for (int i = 1; i < n; i++) {

      same[i] = diff[i - 1] % mod;

      long total = (same[i - 1] % mod + diff[i - 1] % mod) % mod;

      diff[i] = (total % mod * (k - 1) % mod) % mod;
    }

    return (same[n - 1] % mod + diff[n - 1] % mod) % mod;
  }
}

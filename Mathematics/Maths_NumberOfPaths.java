public class Maths_NumberOfPaths {
  long numberOfPaths(int m, int n) {

    long mod = 1_000_000_007L;

    long ans = 1;

    for (long i = n; i <= n + m - 2; i++) {

      ans = (ans * i) % mod;
      long invert = invert(i - n + 1, mod);
      ans = (ans * invert) % mod;

    }

    return ans;
  }

  long pow(long x, long y, long mod) {
    long res = 1;

    while (y > 0) {
      if (y % 2 != 0) {
        res = (res * x) % mod;
      }

      y = y >> 1;
      x = (x * x) % mod;
    }

    return res;
  }

  long invert(long i, long mod) {
    return pow(i, mod - 2, mod);
  }

}

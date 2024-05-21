public class Maths_ModularExponentiation {
  public long PowModIterative(long x, long n, long m) {

    x = x % m;

    if (x == 0)
      return 0;

    long res = 1;

    while (n > 0) {

      if ((n % 2) != 0) {
        res = (x * res) % m;
      }

      n = n >> 1;
      x = (x * x) % m;

    }

    return res;
  }

  public long PowModRecursive(long x, long n, long m) {

    if (x == 0)
      return 0;

    if (n == 0)
      return 1;

    long res;

    if ((n % 2) != 0) {
      res = ((x % m) * PowModRecursive(x, n - 1, m) % m) % m;
    } else {

      res = PowModRecursive(x, n / 2, m) % m;
      res = (res * res) % m;

    }

    return res;
  }
}

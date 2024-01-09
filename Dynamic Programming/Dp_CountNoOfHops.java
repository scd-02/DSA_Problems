public class Dp_CountNoOfHops {
  static long countWays(int n) {
    if (n == 1)
      return 1;

    if (n == 2)
      return 2;

    if (n == 3)
      return 4;

    long count = 0;
    long mod = 1000000007;

    long hop3 = 1, hop2 = 2, hop1 = 4;

    for (int i = 4; i <= n; i++) {

      count = (hop1 % mod + hop2 % mod + hop3 % mod) % mod;

      hop3 = hop2 % mod;
      hop2 = hop1 % mod;
      hop1 = count % mod;

    }
    return count;
  }
}

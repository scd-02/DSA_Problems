public class Maths_CountPossibleWaysToConstructBuildings {
  public int TotalWays(int N) {

    if (N == 0)
      return 0;

    int mod = 1_000_000_000 + 7;

    long fib[] = new long[N + 1];
    fib[0] = 1;
    fib[1] = 2;

    for (int i = 2; i <= N; i++) {
      fib[i] = (fib[i - 1] % mod + fib[i - 2] % mod) % mod;
    }

    return (int) (fib[N] % mod * fib[N] % mod) % mod;
  }
}

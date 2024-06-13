public class Maths_PadovanSequence {
  public int padovanSequence(int n) {
    if (n == 0 || n == 1 || n == 2)
      return 1;

    int mod = 1000_000_000 + 7;
    int p0 = 1, p1 = 1, p2 = 1;

    for (int i = 3; i <= n; i++) {

      int curr = (p0 % mod + p1 % mod) % mod;

      p0 = p1;
      p1 = p2;
      p2 = curr;

    }

    return p2;
  }

}

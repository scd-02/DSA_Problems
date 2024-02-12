public class Rec_RecursiveSequence {
  static long sequence(int n) {

    long ans = 0;
    long cnt = 1;
    long mod = 1_000_000_000 + 7;

    for (int i = 1; i <= n; i++) {
      long temp = 1;

      for (int j = 1; j <= i; j++) {
        temp = (temp * cnt) % mod;
        cnt++;
      }

      ans = (ans % mod + temp % mod) % mod;
    }

    return ans;
  }
}

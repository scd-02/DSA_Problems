public class Dp_Consecutive1sNotAllowed {
  long countStrings(int n) {

    /*
     * Given a positive integer N, count all possible distinct binary strings of
     * length N such that there are no consecutive 1’s. Output your answer modulo
     * 109 + 7.
     */

    long dp0[] = new long[n];
    long dp1[] = new long[n];
    dp0[0] = 1;
    dp1[0] = 1;

    long mod = 1_000_000_000 + 7;

    for (int i = 1; i < n; i++) {

      dp0[i] = (dp0[i - 1] % mod + dp1[i - 1] % mod) % mod;
      dp1[i] = dp0[i - 1] % mod;

    }

    return (dp0[n - 1] + dp1[n - 1]) % mod;
  }

  long count = 0;
  long mod = 1_000_000_000 + 7;

  long countStrings2(int n) {
    solve(1, n, "0");
    solve(1, n, "1");
    return count;
  }

  void solve(int i, int n, String s) {

    if (i == n) {
      count = (count + 1) % mod;
      return;
    }

    if (s.charAt(i - 1) == '0') {
      solve(i + 1, n, s + "0");
      solve(i + 1, n, s + "1");
    } else if (s.charAt(i - 1) == '1') {
      solve(i + 1, n, s + "0");
    }

  }

  long countStrings3(int n) {

    long a = 1, b = 1;

    long mod = 1_000_000_000 + 7;

    for (int i = 1; i < n; i++) {

      long temp = a % mod;
      a = (a % mod + b % mod) % mod;
      b = temp;

    }

    return (a % mod + b % mod) % mod;
  }
  
}

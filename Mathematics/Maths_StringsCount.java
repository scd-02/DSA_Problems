public class Maths_StringsCount {
  static long countStr(long n) {
    long ans = 1l + 2 * n + (n * (n - 1) * (n + 1)) / 2;

    return ans;
  }

  static long countStrRec(long n) {
    long ans[] = new long[1];
    solve("a", n, 1, 0, 0, ans);
    solve("b", n, 1, 1, 0, ans);
    solve("c", n, 1, 0, 1, ans);

    return ans[0];
  }

  static void solve(String s, long n, long count, long b, long c, long ans[]) {

    if (count == n) {
      // System.out.println(s);
      ans[0]++;
      return;
    }

    if (b == 1) {
      if (c == 2) {
        solve(s + "a", n, count + 1, b, c, ans);
        return;
      } else {
        solve(s + "a", n, count + 1, b, c, ans);
        solve(s + "c", n, count + 1, b, c + 1, ans);
        return;
      }
    }

    if (c == 2) {
      if (b == 1) {
        solve(s + "a", n, count + 1, b, c, ans);
        return;
      } else {
        solve(s + "a", n, count + 1, b, c, ans);
        solve(s + "b", n, count + 1, b + 1, c, ans);
        return;
      }
    }

    solve(s + "a", n, count + 1, b, c, ans);
    solve(s + "b", n, count + 1, b + 1, c, ans);
    solve(s + "c", n, count + 1, b, c + 1, ans);
    return;
  }
}

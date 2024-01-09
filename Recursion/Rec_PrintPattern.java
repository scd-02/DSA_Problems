import java.util.ArrayList;
import java.util.List;

public class Rec_PrintPattern {
  public List<Integer> pattern(int N) {

    List<Integer> ans = new ArrayList<>();

    if (N <= 0) {
      ans.add(N);
      return ans;
    }

    dec(N, ans);

    int val = ans.get(ans.size() - 1) - 5;

    inc(N, val, ans);
    return ans;
  }

  public void dec(int n, List<Integer> ans) {
    if (n > 0) {

      ans.add(n);
      dec(n - 5, ans);

    }

  }

  public void inc(int n, int val, List<Integer> ans) {
    if (val > n)
      return;

    ans.add(val);
    inc(n, val + 5, ans);
  }
}

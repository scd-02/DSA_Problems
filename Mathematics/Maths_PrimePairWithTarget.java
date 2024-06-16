import java.util.ArrayList;
import java.util.Arrays;

public class Maths_PrimePairWithTarget {
  public static ArrayList<Integer> getPrimes(int n) {

    boolean prime[] = new boolean[n + 1];
    Arrays.fill(prime, true);

    prime[0] = false;
    prime[1] = false;

    for (int p = 2; p * p <= n; p++) {

      if (prime[p]) {

        for (int i = p * p; i <= n; i += p) {
          prime[i] = false;
        }
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(-1);
    ans.add(-1);

    for (int i = 2; i <= n; i++) {
      if (prime[i] && prime[n - i]) {
        ans.set(0, i);
        ans.set(1, n - i);
        break;
      }
    }

    return ans;
  }
}

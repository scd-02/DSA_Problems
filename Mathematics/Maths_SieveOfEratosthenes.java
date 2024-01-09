import java.util.ArrayList;
import java.util.Arrays;

public class Maths_SieveOfEratosthenes {
  static ArrayList<Integer> sieveOfEratosthenes(int N) {

    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] prime = new boolean[N + 1];

    Arrays.fill(prime, true);

    for (int p = 2; p * p <= N; p++) {

      if (prime[p]) {

        for (int i = p * p; i <= N; i = i + p) {
          prime[i] = false;
        }

      }

    }

    for (int i = 2; i <= N; i++) {
      if (prime[i])
        ans.add(i);
    }

    return ans;
  }
}

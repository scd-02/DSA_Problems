import java.util.HashMap;

public class Maths_FractionsPairsWithSum1 {
  public static int countFractions(int n, int[] num, int[] deno) {

    HashMap<String, Integer> hm = new HashMap<>();
    int count = 0;

    for (int i = 0; i < n; i++) {
      int gcd = gcd(num[i], deno[i]);

      num[i] = num[i] / gcd;
      deno[i] = deno[i] / gcd;

      int num_deno = deno[i] - num[i];
      
      count += hm.getOrDefault(num_deno + "/" + deno[i], 0);
      hm.put(num[i] + "/" + deno[i], hm.getOrDefault(num[i] + "/" + deno[i], 0) + 1);
    }

    return count;
  }

  public static int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }

    if (a % b == 0) {
      return b;
    }

    return gcd(b, a % b);
  }
}

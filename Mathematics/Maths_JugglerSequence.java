import java.util.ArrayList;
import java.util.List;

public class Maths_JugglerSequence {
  static List<Long> jugglerSequence(long n) {

    List<Long> ans = new ArrayList<>();

    while (n != 1) {

      ans.add(n);
      if (n % 2 == 0) {
        n = (long) Math.pow(n, 0.5);
      } else {
        n = (long) Math.pow(n, 1.5);
      }
    }

    ans.add(n);
    return ans;
  }
}

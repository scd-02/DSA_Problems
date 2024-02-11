import java.util.ArrayList;
import java.util.HashSet;

public class Maths_RecamanasSequence {
  static ArrayList<Integer> recamanSequence(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(0);
    HashSet<Integer> hs = new HashSet<>();
    hs.add(0);

    for (int i = 1; i < n; i++) {
      int prev = ans.get(i - 1);

      if ((prev - i <= 0) || hs.contains(prev - i)) {
        ans.add(prev + i);
        hs.add(prev + i);

      } else {
        ans.add(prev - i);
        hs.add(prev - i);
      }
    }

    return ans;
  }
}

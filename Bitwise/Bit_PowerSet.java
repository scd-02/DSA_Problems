import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bit_PowerSet {
  public List<String> AllPossibleStrings(String s) {

    int n = s.length();
    List<String> ans = new ArrayList<>();

    for (int i = 1; i < (1 << n); i++) {

      String res = "";

      for (int j = 0; j < n; j++) {

        if (((1 << j) & i) != 0) {
          res += s.charAt(j);
        }

      }

      ans.add(res);
    }

    Collections.sort(ans);

    return ans;
  }
}

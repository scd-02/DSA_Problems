import java.util.ArrayList;
import java.util.Collections;

public class Bit_ConstructListUsingGivenqXorQueries {

  public static ArrayList<Integer> constructList(int q, int[][] queries) {

    ArrayList<Integer> ans = new ArrayList<>();
    int xor = 0;

    for (int i = q - 1; i >= 0; i--) {

      if (queries[i][0] == 0) {
        ans.add(queries[i][1] ^ xor);
      } else {
        xor ^= queries[i][1];
      }
    }

    ans.add(xor);
    Collections.sort(ans);

    return ans;
  }
}
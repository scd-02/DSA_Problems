import java.util.ArrayList;
import java.util.HashSet;

public class Hash_FindDuplicateRowsInABinaryMatrix {
  public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {

    ArrayList<Integer> ans = new ArrayList<>();

    HashSet<String> hs = new HashSet<>();

    for (int i = 0; i < m; i++) {

      String s = "";

      for (int j = 0; j < n; j++) {

        s += matrix[i][j];

      }

      if (hs.contains(s)) {
        ans.add(i);
      } else {
        hs.add(s);
      }

    }

    return ans;
  }
}

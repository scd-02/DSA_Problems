import java.util.ArrayList;
import java.util.HashMap;

public class HashMap_CountDistinctElementsInEveryWindow {
  ArrayList<Integer> countDistinct(int A[], int n, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    int start = 0;
    for (int i = 0; i < n; i++) {

      map.put(A[i], map.getOrDefault(A[i], 0) + 1);

      if ((i - start + 1) == k) {

        ans.add(map.size());

        map.put(A[start], map.get(A[start]) - 1);

        if (map.get(A[start]) == 0)
          map.remove(A[start]);

        start++;
      }

    }
    return ans;
  }
}

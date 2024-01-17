import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BackTracking_AllUniquePermutationsOfArray {
  static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {

    HashSet<ArrayList<Integer>> hs = new HashSet<>();
    Collections.sort(arr);

    solve(0, arr, n, hs);

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>(hs);

    ans.sort((a, b) -> {

      for (int i = 0; i < a.size(); i++) {
        int cmp = a.get(i).compareTo(b.get(i));
        if (cmp != 0) {
          return cmp;
        }
      }

      return 0;
    });

    return ans;
  }

  static void solve(int start, ArrayList<Integer> arr, int n, HashSet<ArrayList<Integer>> hs) {

    if (start == n - 1) {
      hs.add(new ArrayList<>(arr));
      return;
    }

    for (int i = start; i < n; i++) {
      swap(arr, i, start);
      solve(start + 1, arr, n, hs);
      swap(arr, i, start);
    }
  }

  static void swap(ArrayList<Integer> arr, int i, int j) {
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }
}

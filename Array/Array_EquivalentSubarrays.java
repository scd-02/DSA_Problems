import java.util.HashMap;
import java.util.HashSet;

public class Array_EquivalentSubarrays {
  static int countDistinctSubarray(int arr[], int n) {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> hs = new HashSet<>();

    for (int i = 0; i < n; i++) {
      hs.add(arr[i]);
    }

    int distinct = hs.size();

    int start = 0;
    int count = 0;

    for (int i = 0; i < n; i++) {

      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

      while (map.size() == distinct) {

        count += n - i;
        map.put(arr[start], map.get(arr[start]) - 1);

        if (map.get(arr[start]) == 0)
          map.remove(arr[start]);

        start++;
      }

    }

    return count;
  }
}

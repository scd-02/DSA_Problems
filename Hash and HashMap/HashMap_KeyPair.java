import java.util.HashMap;

public class HashMap_KeyPair {
  boolean hasArrayTwoCandidates(int arr[], int n, int x) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {

      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

    }

    for (int i = 0; i < n; i++) {

      int diff = x - arr[i];
      if (map.containsKey(diff)) {

        if (arr[i] != diff)
          return true;
        else if (map.get(diff) > 1) {
          return true;
        }
      }

    }

    return false;
  }
}

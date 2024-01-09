import java.util.HashMap;

public class HashMap_SubarrayWith0Sum {
  static boolean findsum(int arr[], int n) {

    HashMap<Integer, Boolean> map = new HashMap<>();
    map.put(0, true);

    int sum = 0;
    for (int i = 0; i < n; i++) {

      sum += arr[i];

      if (map.containsKey(sum))
        return true;
      else
        map.put(sum, true);
    }

    return false;
  }
}

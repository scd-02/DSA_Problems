import java.util.HashMap;
import java.util.Map;

public class Array_MoreThanNbyKOcc {
  public int countOccurence(int[] arr, int n, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    int count = 0;
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      int value = e.getValue();
      if (value > (n / k)) {
        count++;
      }
    }

    return count;
  }
}

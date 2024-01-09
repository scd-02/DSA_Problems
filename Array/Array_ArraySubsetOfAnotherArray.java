import java.util.HashMap;

public class Array_ArraySubsetOfAnotherArray {
  public String isSubset(long a1[], long a2[], long n, long m) {

    HashMap<Long, Long> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (map.containsKey(a1[i])) {
        map.put(a1[i], map.get(a1[i]) + 1l);
      } else {
        map.put(a1[i], 1l);
      }
    }

    boolean flag = true;
    for (int i = 0; i < m; i++) {
      if (map.containsKey(a2[i]) && map.get(a2[i]) != 0) {
        map.put(a2[i], map.get(a2[i]) - 1l);
      } else {
        flag = false;
        break;
      }
    }

    return flag ? "Yes" : "No";
  }
}

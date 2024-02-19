import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap_GameWithString {
  static int minValue(String s, int k) {

    HashMap<Character, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      hm.put(ch, hm.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for (Map.Entry<Character, Integer> pair : hm.entrySet()) {
      q.add(pair.getValue());
    }

    while (k > 0) {
      int u = q.poll();
      q.add(u - 1);
      k--;
    }

    int sum = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      sum += u * u;
    }

    return sum;
  }
}

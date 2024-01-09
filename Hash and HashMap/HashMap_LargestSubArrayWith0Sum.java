import java.util.HashMap;

public class HashMap_LargestSubArrayWith0Sum {
  int maxLen(int a[], int n) {
    HashMap<Integer, Integer> hs = new HashMap<>();

    int sum = 0;
    int maxLength = 0;

    for (int i = 0; i < n; i++) {
      sum += a[i];

      if (sum == 0) {
        maxLength = i + 1;
      }

      Integer prev_i = hs.get(sum);

      if (prev_i != null) {
        maxLength = Math.max(maxLength, i - prev_i);
      } else {
        hs.put(sum, i);
      }
    }

    return maxLength;

  }
}

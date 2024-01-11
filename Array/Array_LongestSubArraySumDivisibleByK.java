import java.util.Arrays;
import java.util.HashMap;

public class Array_LongestSubArraySumDivisibleByK {
  // T(N) = O(N^2) and S(N) = O(N)
  int longSubarrWthSumDivByKPrefixSum(int a[], int n, int k) {
    int prefix[] = new int[n];
    prefix[0] = a[0];

    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + a[i];
    }

    int maxLen = 0;
    for (int i = 0; i < n; i++) {

      if ((prefix[i] % k) == 0) {
        maxLen = Math.max(maxLen, i + 1);
      } else {
        for (int j = 0; j < i; j++) {

          int sum = prefix[i] - prefix[j];

          if (sum % k == 0) {
            maxLen = Math.max(maxLen, i - j);
            break;
          }
        }
      }
    }

    return maxLen;
  }

  // time optimization T(N) = O(N) and S(N) = O(N)
  int longSubarrWthSumDivByK(int a[], int n, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int maxLen = 0;
    int sum = 0;

    for (int i = 0; i < n; i++) {

      sum += a[i];
      int r = sum % k;

      if (r < 0)
        r += k;

      if (map.containsKey(r)) {
        maxLen = Math.max(maxLen, i - map.get(r));
        continue;
      }

      map.put(r, i);
    }

    return maxLen;
  }

  // with space optimization s(n) = O(k)
  int longSubarrWthSumDivByK2(int a[], int n, int k) {
    int rem[] = new int[k];
    Arrays.fill(rem, Integer.MIN_VALUE);
    rem[0] = -1;

    int maxLen = 0;
    int sum = 0;

    for (int i = 0; i < n; i++) {

      sum += a[i];
      int r = sum % k;

      if (r < 0)
        r += k;

      if (rem[r] != Integer.MIN_VALUE) {
        maxLen = Math.max(maxLen, i - rem[r]);
        continue;
      }

      rem[r] = i;
    }

    return maxLen;
  }
}

import java.util.ArrayList;

public class Dp_LongestIncreasingSubsequence {

  static int longestSubsequence(int size, int a[]) {

    ArrayList<Integer> dp = new ArrayList<>();
    dp.add(a[0]);

    for (int i = 1; i < size; i++) {
      if (dp.get(dp.size() - 1) < a[i]) {
        dp.add(a[i]);
      } else {
        int index = binarySearch(dp, a[i]);
        dp.set(index, a[i]);
      }
    }

    return dp.size();
  }

  static int binarySearch(ArrayList<Integer> list, int key) {

    int s = 0, e = list.size() - 1;

    while (s <= e) {
      int mid = (s + e) / 2;

      if (list.get(mid) >= key) {
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }

    return s;
  }

  static int longestSubsequenceBottomUp(int size, int a[]) {
    int dp[] = new int[size];

    int maxLength = 0;

    for (int i = 0; i < size; i++) {

      int max = 0;

      for (int j = 0; j < i; j++) {
        if (a[j] < a[i]) {
          max = Math.max(dp[j], max);
        }
      }

      dp[i] = max + 1;
      maxLength = Math.max(dp[i], maxLength);
    }

    return maxLength;
  }
}

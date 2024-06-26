import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BackTracking_PrintLongestIncreasingSubsequence {
  public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {

    int dp[] = new int[n];
    Arrays.fill(dp, 1);

    int track[] = new int[n];

    int len = -1;
    int lastIndex = -1;

    for (int i = 0; i < n; i++) {
      track[i] = i;

      for (int prev = 0; prev < i; prev++) {
        if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
          dp[i] = 1 + dp[prev];
          track[i] = prev;
        }
      }

      if (len < dp[i]) {
        len = dp[i];
        lastIndex = i;
      }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(arr[lastIndex]);

    while (track[lastIndex] != lastIndex) {

      lastIndex = track[lastIndex];
      ans.add(arr[lastIndex]);

    }

    Collections.reverse(ans);

    return ans;

  }
}

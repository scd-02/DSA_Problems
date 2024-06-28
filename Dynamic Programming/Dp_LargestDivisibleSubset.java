import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Dp_LargestDivisibleSubset {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);

    int dp[] = new int[nums.length];
    Arrays.fill(dp, 1);

    int track[] = new int[nums.length];

    int maxLen = -1;
    int lastIndex = -1;

    for (int i = 1; i < nums.length; i++) {
      track[i] = i;

      for (int j = 0; j < i; j++) {

        if ((nums[i] % nums[j] == 0) && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          track[i] = j;
        }

      }

    }

    for (int i = 0; i < nums.length; i++) {

      if (maxLen < dp[i]) {
        maxLen = dp[i];
        lastIndex = i;
      }

    }

    List<Integer> ans = new ArrayList<>();
    ans.add(nums[lastIndex]);

    while (track[lastIndex] != lastIndex) {
      lastIndex = track[lastIndex];
      ans.add(nums[lastIndex]);
    }

    return ans;
  }
}

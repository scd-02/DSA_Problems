import java.util.Arrays;

public class Greedy_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
  public int minDifference(int[] nums) {

    int n = nums.length;

    if (n <= 4)
      return 0;

    Arrays.sort(nums);

    int minDiff = Integer.MAX_VALUE;

    for (int left = 0, right = n - 4; left <= 3; left++, right++) {
      minDiff = Math.min(nums[right] - nums[left], minDiff);
    }

    return minDiff;
  }
}

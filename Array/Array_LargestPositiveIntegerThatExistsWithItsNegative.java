import java.util.Arrays;

public class Array_LargestPositiveIntegerThatExistsWithItsNegative {
  public int findMaxK(int[] nums) {
    Arrays.sort(nums);

    int s = 0, e = nums.length - 1;
    while (s < e) {

      if (nums[s] < 0 && nums[e] > 0) {
        if (Math.abs(nums[s]) == nums[e]) {
          return nums[e];
        } else if (Math.abs(nums[s]) < nums[e]) {
          e--;
        } else {
          s++;
        }
      } else {
        break;
      }
    }

    return -1;
  }

  public int findMaxK2(int[] nums) {

    int sum[] = new int[1001];
    int max = -1;
    for (int val : nums) {
      int index = val > 0 ? val : -val;

      if (sum[index] != val) {
        sum[index] += val;
      }

      if (sum[index] == 0) {
        max = Math.max(max, index);
      }
    }

    return max;
  }
}

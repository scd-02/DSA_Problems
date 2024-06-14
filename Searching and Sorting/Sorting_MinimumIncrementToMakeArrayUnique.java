import java.util.Arrays;

public class Sorting_MinimumIncrementToMakeArrayUnique {

  public int minIncrementForUniqueCountingSort(int[] nums) {
    int n = nums.length;

    int max = 0;
    for (int ele : nums) {
      max = Math.max(max, ele);
    }

    int freq[] = new int[max + n];

    for (int i = 0; i < n; i++) {
      freq[nums[i]]++;
    }

    int count = 0;
    for (int i = 0; i < freq.length; i++) {

      if (freq[i] <= 1)
        continue;

      int duplicates = freq[i] - 1;
      count += duplicates;

      freq[i + 1] += duplicates;
      freq[i] = 1;

    }

    return count;
  }

  public int minIncrementForUnique(int[] nums) {

    int count = 0;
    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {

        count += nums[i - 1] - nums[i] + 1;
        nums[i] = nums[i - 1] + 1;
      }
    }

    return count;
  }
}

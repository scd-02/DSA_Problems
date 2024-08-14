import java.util.Arrays;

public class Bs_FindKthSmallesPairDistance {
  public int smallestDistancePair(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);

    int low = 0;
    int high = nums[n - 1] - nums[0];

    while (low < high) {
      int mid = (low + high) / 2;

      int count = countPairsWithMaxDistance(nums, mid);

      if (count < k)
        low = mid + 1;
      else
        high = mid;
    }

    return low;
  }

  private int countPairsWithMaxDistance(int nums[], int distance) {

    int count = 0;

    int left = 0;
    for (int right = 0; right < nums.length; right++) {

      while (nums[right] - nums[left] > distance) {
        left++;
      }

      count += right - left;
    }

    return count;
  }
}

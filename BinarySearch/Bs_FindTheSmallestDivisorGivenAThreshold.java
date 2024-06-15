public class Bs_FindTheSmallestDivisorGivenAThreshold {
  public int smallestDivisor(int[] nums, int threshold) {
    int low = 1, high = nums[0];

    for (int ele : nums) {
      high = Math.max(ele, high);
    }

    while (low <= high) {
      int mid = (low + high) / 2;

      int sum = sumOfDivison(nums, mid);

      if (sum <= threshold) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  int sumOfDivison(int nums[], int mid) {
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += Math.ceilDiv(nums[i], mid);
    }

    return sum;
  }
}

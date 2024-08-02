public class SW_MinimumSwapsToGroupAll1sTogether2 {
  public int minSwaps(int[] nums) {

    int minSwaps = Integer.MAX_VALUE;

    // count the total number of ones
    int totalOnes = 0;
    for (int ele : nums) {
      totalOnes += ele;
    }

    int currOnesCount = nums[0];
    int end = 0;

    // slide the window across the array and window length is totalOnes
    for (int start = 0; start < nums.length; start++) {

      // adjust ones count by removing the element that is sliding out of window
      if (start != 0) {
        currOnesCount -= nums[start - 1];
      }

      // expand the window until it reaches the desired window length
      while (end - start + 1 < totalOnes) {
        end++;
        currOnesCount += nums[end % nums.length];
      }

      // update the minimum number of swaps needed
      minSwaps = Math.min(minSwaps, totalOnes - currOnesCount);
    }

    return minSwaps;
  }
}

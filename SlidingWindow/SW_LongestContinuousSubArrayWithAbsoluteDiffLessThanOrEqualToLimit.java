import java.util.Deque;
import java.util.LinkedList;

public class SW_LongestContinuousSubArrayWithAbsoluteDiffLessThanOrEqualToLimit {
  public int longestSubarray(int[] nums, int limit) {

    int left = 0;
    int maxLen = 0;

    Deque<Integer> minDeque = new LinkedList<>();
    Deque<Integer> maxDeque = new LinkedList<>();

    for (int right = 0; right < nums.length; right++) {

      while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
        maxDeque.pollLast();
      }
      maxDeque.offerLast(nums[right]);

      while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
        minDeque.pollLast();
      }
      minDeque.offerLast(nums[right]);

      while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {

        if (maxDeque.peekFirst() == nums[left]) {
          maxDeque.pollFirst();
        }

        if (minDeque.peekFirst() == nums[left]) {
          minDeque.pollFirst();
        }

        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }
}

package PrefixSum;

import java.util.HashMap;

public class PrefixSum_MakeSumDivisibleByP {

  public int minSubarray(int[] nums, int p) {

    int n = nums.length;
    int totalSum = 0;

    for (int ele : nums) {
      totalSum = (ele + totalSum) % p;
    }

    int remToRemove = totalSum % p;
    if (remToRemove == 0)
      return 0;

    HashMap<Integer, Integer> modIndexMap = new HashMap<>();
    modIndexMap.put(0, -1);

    int currSum = 0, minLen = n;

    for (int i = 0; i < n; i++) {
      currSum = (currSum + nums[i]) % p;
      int needed = (currSum - remToRemove + p) % p;
      if (modIndexMap.containsKey(needed)) {
        minLen = Math.min(minLen, i - modIndexMap.get(needed));
      }

      modIndexMap.put(currSum, i);
    }

    return minLen == n ? -1 : minLen;
  }

}

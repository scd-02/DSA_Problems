import java.util.HashMap;

public class HashMap_ContinuousSubArraySum {
  public boolean checkSubarraySum(int[] nums, int k) {

    int n = nums.length;

    HashMap<Integer, Integer> prefixModSeen = new HashMap<>();
    prefixModSeen.put(0, -1);

    int prefixMod = 0;
    for (int i = 0; i < n; i++) {

      prefixMod = (prefixMod + nums[i]) % k;

      if (prefixModSeen.containsKey(prefixMod)) {
        if (i - prefixModSeen.get(prefixMod) > 1)
          return true;
      } else {
        prefixModSeen.put(prefixMod, i);
      }

    }

    return false;
  }
}

import java.util.HashMap;

public class Array_SubArraySumsDivisibleByK {
  public int subarraysDivByK(int[] nums, int k) {

    int count = 0;
    int sum = 0, rem = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(0, 1);

    for (int i = 0; i < nums.length; i++) {

      sum += nums[i];
      rem = sum % k;
      if (rem < 0)
        rem = rem + k;

      if (hm.containsKey(rem)) {
        count += hm.get(rem);
        hm.put(rem, hm.get(rem) + 1);
      } else {
        hm.put(rem, 1);
      }

    }

    return count;
  }
}

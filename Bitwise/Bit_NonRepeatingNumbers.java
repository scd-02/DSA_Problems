public class Bit_NonRepeatingNumbers {
  public int[] singleNumber(int[] nums) {
    int xorSum = 0;
    for (int e : nums) {
      xorSum ^= e;
    }

    int mask = xorSum & (~(xorSum - 1));
    int first = 0, second = 0;

    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & mask) == 0) {
        first ^= nums[i];
      } else {
        second ^= nums[i];
      }
    }

    int ans[] = new int[2];
    ans[0] = Math.min(first, second);
    ans[1] = Math.max(first, second);

    return ans;
  }
}

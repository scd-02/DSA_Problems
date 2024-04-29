public class Bit_MinimumNoOfOperationsToMakeArrayXorEqualToK {
  public int minOperations(int[] nums, int k) {

    int xor = 0;
    for (int ele : nums) {
      xor ^= ele;
    }

    xor ^= k;

    int count = 0;
    while (xor > 0) {
      xor = xor & (xor - 1);
      count++;
    }

    return count;
  }
}

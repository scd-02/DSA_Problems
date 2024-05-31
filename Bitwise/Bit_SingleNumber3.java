public class Bit_SingleNumber3 {
  public int[] singleNumber(int[] nums) {

    int xor = 0;

    for (int ele : nums) {
      xor ^= ele;
    }

    xor = xor & (~(xor - 1));
    int a = 0, b = 0;

    for (int ele : nums) {
      if ((xor & ele) == xor) {
        a ^= ele;
      } else {
        b ^= ele;
      }
    }

    return new int[] { a, b };
  }
}

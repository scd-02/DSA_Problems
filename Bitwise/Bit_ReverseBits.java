public class Bit_ReverseBits {
  static Long reversedBits(Long X) {
    // code here
    long temp = X;
    long ans = 0;

    for (int i = 31; i >= 0; i--) {

      long mask = (temp & 1) << i;
      ans = ans | mask;
      temp = temp >> 1;

    }

    return ans;
  }
}

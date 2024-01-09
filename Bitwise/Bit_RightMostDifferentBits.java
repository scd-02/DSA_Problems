public class Bit_RightMostDifferentBits {
  public static int posOfRightMostDiffBit(int m, int n) {

    if (m == n)
      return -1;

    for (int i = 0; i < 31; i++) {

      int bit_m = m & 1;
      int bit_n = n & 1;

      if ((bit_m ^ bit_n) == 1) {
        return i + 1;
      }

      m = m >> 1;
      n = n >> 1;
    }

    return -1;
  }

  public static int posOfRightMostDiffBit2(int m, int n) {

    if (m == n)
      return -1;

    int xor = m ^ n;

    int pos = xor & -xor;

    return (int) (Math.log((double) pos) / Math.log(2.0)) + 1;
  }
}

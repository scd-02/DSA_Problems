public class Bit_CountTotalSetBits {
  public static int countSetBits(int n) {

    if (n == 0 || n == 1)
      return n;

    // largest power of 2 less than or equal to n
    int x = (int) (Math.log(n) / Math.log(2));

    int countX = (int) Math.pow(2, x - 1) * x;

    // count all msb between 2^x and n
    int countY = n - (int) Math.pow(2, x) + 1;

    return countX + countY + countSetBits(n - (int) Math.pow(2, x));

  }
}

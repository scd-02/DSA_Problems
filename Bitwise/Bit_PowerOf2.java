public class Bit_PowerOf2 {
  public static boolean isPowerofTwo(long n) {
    int count = 0;

    while (n != 0) {

      count++;
      n = n & (n - 1);

    }

    return count == 1;

  }

  public static boolean isPowerofTwo2(long n) {
    if (n == 0)
      return false;

    long a = n & (n - 1);
    return a == 0l;

  }
}

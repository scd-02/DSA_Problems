public class Bit_DivideWithoutUsingMultiplication {
  public static long divideBit(long a, long b) {

    boolean sign = (a < 0) ^ (b < 0) ? true : false;

    a = (long) Math.abs(a);
    b = (long) Math.abs(b);

    long quotient = 0, product = 0;

    for (int i = 31; i >= 0; i--) {

      if (product + (b << i) <= a) {

        product += (b << i);
        quotient |= (1l << i);

      }

    }

    return sign ? -quotient : quotient;
  }

  public static long divide(long a, long b) {

    boolean sign = (a < 0) ^ (b < 0) ? true : false;

    a = (long) Math.abs(a);
    b = (long) Math.abs(b);

    long quotient = (long) (Math.exp(Math.log(a) - Math.log(b)) + 0.0000000001);

    return sign ? -quotient : quotient;
  }
}

public class Maths_SumOfSquareNumbers {
  public boolean judgeSquareSum(int c) {
    /*
     * Fermat's Theorem:
     * 
     * Any positive number n is expressible as a sum of two squares if and only if
     * the prime factorization of n, every prime of the form (4k+3)
     * occurs an even number of times.
     */
    for (int i = 2; i * i <= c; i++) {
      int count = 0;
      if (c % i == 0) {
        while (c % i == 0) {
          count++;
          c /= i;
        }

        if (((i % 4) == 3) && ((count % 2) != 0)) {
          return false;
        }
      }
    }
    return c % 4 != 3;
  }

  class SolutionUsingBS {
    public boolean judgeSquareSum(int c) {

      for (long a = 0; a * a <= c; a++) {
        int b = c - (int) (a * a);
        if (isIntegerSqrt(b)) {
          return true;
        }
      }

      return false;
    }

    boolean isIntegerSqrt(int b) {

      long low = 0, high = b;

      while (low <= high) {
        long mid = (low + high) / 2;

        if (mid * mid == b)
          return true;
        else if (mid * mid > b)
          high = mid - 1;
        else
          low = mid + 1;
      }

      return false;
    }
  }
}

public class Maths_SquareRootOfANumber {
  long floorSqrt(long x) {
    long low = 1, high = x;
    long ans = 0;

    while (low <= high) {

      long mid = (low + high) / 2;

      if (mid * mid <= x) {
        ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return ans;
  }
}

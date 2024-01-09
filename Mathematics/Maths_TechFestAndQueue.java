public class Maths_TechFestAndQueue {
  public static long sumOfPowers(long a, long b) {

    long totalSum = 0;

    for (long i = a; i <= b; i++) {

      totalSum += solve(i);

    }

    return totalSum;

  }

  static long solve(long a) {

    long count = 0;

    for (int i = 2; i * i <= a; i++) {

      while (a % i == 0) {
        count++;
        a /= i;
      }

    }

    if (a != 1)
      count++;

    return count;
  }
}

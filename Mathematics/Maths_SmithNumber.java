public class Maths_SmithNumber {
  static int smithNum(int n) {

    if (isPrime(n))
      return 0;

    int sumPrime = sumOfPrimeFactors(n);
    int sumOfDigits = sumOfDigits(n);

    return sumPrime == sumOfDigits ? 1 : 0;
  }

  static boolean isPrime(int n) {

    for (int i = 2; i * i <= n; i++) {
      if ((n % i) == 0)
        return false;
    }

    return true;
  }

  static int sumOfPrimeFactors(int n) {

    int result = 0;

    int i = 2;
    while (n > 1) {

      while (n % i == 0) {
        result += sumOfDigits(i);
        n /= i;
      }

      i++;
    }

    return result;
  }

  static int sumOfDigits(int n) {

    int sum = 0;

    while (n > 0) {

      sum += n % 10;
      n /= 10;
    }

    return sum;
  }
}

public class Maths_TransformToPrime {
  public int minNumber(int arr[], int N) {
    int sum = 0;

    for (int i = 0; i < N; i++) {
      sum += arr[i];
    }

    int nextPrime = nextPrime(sum);

    int diff = nextPrime - sum;

    return diff;
  }

  public int nextPrime(int n) {

    if (n <= 1)
      return 2;

    while (true) {

      if (isPrime(n)) {
        break;
      }

      n++;
    }

    return n;
  }

  public boolean isPrime(int n) {

    if (n <= 1)
      return false;
    if (n <= 3)
      return true;

    if (n % 2 == 0 || n % 3 == 0)
      return false;

    for (int i = 5; i * i <= n; i = i + 6) {

      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    }

    return true;
  }
}

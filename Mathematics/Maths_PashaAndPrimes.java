import java.util.ArrayList;
import java.util.HashSet;

public class Maths_PashaAndPrimes {
  ArrayList<Integer> primeRange(int N, int Q, int A[], int R[][]) {
    /*
     * Given an array of N integers and another array R containing Q queries(of l
     * and r). Answer all Q queries asking the number of primes in the subarray
     * ranging from l to r (both inclusive).
     * Note: A is 0-based but the queries will be 1-based.
     */

    int prime[] = new int[N];
    HashSet<Integer> hs = new HashSet<>();

    if (isPrime(A[0])) {
      hs.add(A[0]);
      prime[0] = 1;
    }

    for (int i = 1; i < N; i++) {

      if (isPrime(A[i])) {
        prime[i] = prime[i - 1] + 1;
        hs.add(A[i]);
      } else {
        prime[i] = prime[i - 1];
      }

    }

    ArrayList<Integer> ans = new ArrayList<>();

    for (int i = 0; i < Q; i++) {
      int first = R[i][0] - 1;
      int last = R[i][1] - 1;

      if (first == last) {
        if (hs.contains(A[first])) {
          ans.add(1);
        } else {
          ans.add(0);
        }
      } else {
        int count = 0;

        if (first != 0) {
          count = prime[last] - prime[first - 1];
        } else {
          count = prime[last];
        }

        ans.add(count);
      }
    }

    return ans;
  }

  static boolean isPrime(int n) {
    if (n <= 1)
      return false;

    for (int i = 2; i * i <= n; i++) {
      if ((n % i) == 0)
        return false;
    }

    return true;
  }
}

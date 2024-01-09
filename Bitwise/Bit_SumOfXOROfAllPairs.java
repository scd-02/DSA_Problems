public class Bit_SumOfXOROfAllPairs {
  /*
   * Given an array of N integers, find the sum of xor of all pairs of numbers in
   * the array arr. In other words, select all possible pairs of i and j from 0 to
   * N-1 (i<j) and determine sum of all (arri xor arrj).
   */
  
  public long sumXOR(int arr[], int n) {

    long ans = 0;

    for (int pos = 0; pos < 32; pos++) {

      long count1 = 0, count0 = 0;
      int mask = (1 << pos);

      for (int i = 0; i < n; i++) {

        if ((arr[i] & mask) == mask) {
          count1++;
        } else {
          count0++;
        }

      }

      ans = ans + (count1 * count0 * mask);
    }

    return ans;
  }
}

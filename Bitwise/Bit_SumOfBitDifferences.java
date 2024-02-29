public class Bit_SumOfBitDifferences {
  long sumBitDifferences(int[] arr, int n) {

    long ans = 0;

    // upto 20 because: 10^5 < 2^20 so checking upto 20 bits will be sufficient
    for (int bit = 0; bit < 20; bit++) {

      long count0 = 0, count1 = 0;

      // for each item in arr calculating the no of 0s and 1s at that particular bit
      // position
      for (int i = 0; i < n; i++) {

        if (((arr[i] >> bit) & 1) == 1) {
          count1++;
        } else {
          count0++;
        }

      }

      ans += (count0 * count1);
    }
    return ans * 2;
  }
}

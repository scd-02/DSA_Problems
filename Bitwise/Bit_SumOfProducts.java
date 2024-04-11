public class Bit_SumOfProducts {
  static long pairAndSum(int n, long arr[]) {

    long res = 0;

    for (int bit = 0; bit < 32; bit++) {

      long count = 0; // no of elements contributing 1 in this bit position

      for (int i = 0; i < n; i++) {

        if ((arr[i] & (1l << bit)) != 0) {
          count++;
        }
      }

      long pairs = (count * (count - 1)) / 2; // total pairs formed contributing for this bit position
      res += pairs * (1l << bit); // these pairs contributing 2^(bit) in result
    }

    return res;
  }
}

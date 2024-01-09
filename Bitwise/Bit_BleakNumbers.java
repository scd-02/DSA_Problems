public class Bit_BleakNumbers {

  public int is_bleak(int n) {
    int lower_Bound = (int) (Math.log(n) / Math.log(2)) + 1;

    for (int i = n - lower_Bound; i < n; i++) {
      int sum = i + countSetBits(i);

      if (sum == n)
        return 0;

    }

    return 1;
  }

  int countSetBits(int n) {
    int count = 0;

    while (n != 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }
}

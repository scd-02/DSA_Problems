public class Bit_MaximizeXOR {
  public int maximize_xor_count(int n) {

    int count = 0;
    int i = 0;

    while ((1 << i) <= n) {

      if ((n & (1 << i)) == 0) {
        count += Math.pow(2, i);
      }

      i++;
    }

    return count;
  }
}

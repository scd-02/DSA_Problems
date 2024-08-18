public class Dp_UglyNumber2 {
  public int nthUglyNumber(int n) {

    int index_2 = 0, index_3 = 0, index_5 = 0;
    int nextMultiple_2 = 2, nextMultiple_3 = 3, nextMultiple_5 = 5;

    int ugly[] = new int[n];
    ugly[0] = 1;

    for (int i = 1; i < n; i++) {
      ugly[i] = Math.min(nextMultiple_2, Math.min(nextMultiple_3, nextMultiple_5));

      if (ugly[i] == nextMultiple_2) {
        ++index_2;
        nextMultiple_2 = ugly[index_2] * 2;
      }

      if (ugly[i] == nextMultiple_3) {
        ++index_3;
        nextMultiple_3 = ugly[index_3] * 3;
      }

      if (ugly[i] == nextMultiple_5) {
        ++index_5;
        nextMultiple_5 = ugly[index_5] * 5;
      }
    }

    return ugly[n - 1];
  }
}

public class Bit_SetAllTheBitsInGivenRangeOfANum {

  static int setAllRangeBits(int N, int L, int R) {

    for (int i = L - 1; i < R; i++) {
      N = N | (1 << i);
    }

    return N;
  }

  static int setAllRangeBits2(int N, int L, int R) {

    int mask = ((1 << (L - 1)) - 1) ^ ((1 << (R)) - 1);

    return N | mask;
  }
}
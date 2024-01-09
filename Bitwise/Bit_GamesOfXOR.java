public class Bit_GamesOfXOR {
  static int gameOfXor(int N, int[] A) {

    if (N % 2 == 0)
      return 0;

    int sum = 0;

    for (int i = 0; i < N; i += 2) {

      sum ^= A[i];

    }

    return sum;
  }
}

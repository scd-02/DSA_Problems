public class Bit_VariationInNimGame {
  static int findWinner(int n, int A[]) {
    // code here
    int xor = 0;
    for (int i = 0; i < n; i++) {
      xor ^= A[i];
    }

    if (xor == 0 || n % 2 == 0)
      return 1;
    return 2;

  }
}

public class Maths_GrayToBinaryEquivalent {
  public static int grayToBinary(int n) {
    if (n == 0)
      return 0;

    int pow = (int) (Math.log(n) / Math.log(2));

    int xor = (n >> pow) & 1;
    int ans = xor << pow;

    for (int i = pow - 1; i >= 0; i--) {

      xor = ((n >> i) & 1) ^ xor;
      ans = ans | (xor << i);
    }

    return ans;
  }
}

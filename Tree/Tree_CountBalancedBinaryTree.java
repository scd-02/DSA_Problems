public class Tree_CountBalancedBinaryTree {
  static long mod = 1000000007;
  /*
   * For height balanced binary tree at any height h
   * either height of left and right subtree will be
   * (h-1)(h-2)
   * (h-2)(h-1)
   * (h-1)(h-1)
   * h[i] = h[i-1] * h[i-1] + h[i-2] * h[i-1] + h[i-2] * h[i-1]
   * h[i] = h[i-1] * h[i-1] + (2 * h[i-2] * h[i-1])
   * h[i] = h[i-1] * (2 * h[i-2] + h[i-1])
   */

  static long countBT(int h) {
    if (h == 0 || h == 1) {
      return 1;
    }
    long a[] = new long[h + 1];
    a[0] = 1;
    a[1] = 1;
    for (int i = 2; i <= h; i++) {
      a[i] = (a[i - 1]) * ((2 * a[i - 2]) % mod + a[i - 1] % mod) % mod;
    }
    return a[h];
  }
}

import java.util.Arrays;

@SuppressWarnings("unused")
public class Dp_2KeysKeyboard {
  int n;

  public int minSteps(int n) {

    if (n == 1)
      return 0;
    this.n = n;

    // return 1 + rec(1, 1);

    // int [][]dp = new int[n + 1][n / 2 + 1];
    // return 1 + mem(1, 1, dp);

    // return tab(n);

    return optimized(n);
  }

  private int rec(int currLen, int copyLen) {

    if (currLen == n)
      return 0;

    if (currLen > n)
      return 1000;

    // copy all + paste operations
    int opr1 = 2 + rec(currLen * 2, currLen);

    // only paste operation
    int opr2 = 1 + rec(currLen + copyLen, copyLen);

    return Math.min(opr1, opr2);
  }

  
  private int mem(int currLen, int copyLen, int dp[][]) {

    if (currLen == n)
      return 0;

    if (currLen > n)
      return 1000;

    if (dp[currLen][copyLen] != 0)
      return dp[currLen][copyLen];

    // copy all + paste operations
    int opr1 = 2 + rec(currLen * 2, currLen);

    // only paste operation
    int opr2 = 1 + rec(currLen + copyLen, copyLen);

    return dp[currLen][copyLen] = Math.min(opr1, opr2);
  }

  private int tab(int n) {

    int[] dp = new int[n + 1];
    Arrays.fill(dp, 1000);

    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i / 2; j++) {

        if (i % j == 0) {
          dp[i] = Math.min(dp[i], dp[j] + i / j);
        }

      }
    }

    return dp[n];
  }

  private int optimized(int n) {
    if (n == 1)
      return 0;

    int steps = 0;
    int factor = 2;

    while (n > 1) {

      while (n % factor == 0) {
        steps += factor;
        n /= factor;
      }

      factor++;
    }

    return steps;
  }
}

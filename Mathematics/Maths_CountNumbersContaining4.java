public class Maths_CountNumbersContaining4 {
  public static int countNumberswith4(int n) {

    if (n < 4)
      return 0;

    int d = (int) Math.log10(n);

    int dp[] = new int[d + 2];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= d; i++) {
      dp[i] = dp[i - 1] * 9 + (int) Math.pow(10, i - 1);
    }

    int p = (int) Math.pow(10, d);

    int msd = n / p;

    if (msd == 4)
      return msd * dp[d] + (n % p) + 1;

    if (msd > 4)
      return (msd - 1) * dp[d] + p + countNumberswith4(n % p);

    return msd * dp[d] + countNumberswith4(n % p);
  }
}

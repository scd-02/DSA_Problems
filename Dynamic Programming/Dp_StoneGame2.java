public class Dp_StoneGame2 {
  public int stoneGameII(int[] piles) {
    int n = piles.length;

    int[] suffixSum = new int[n];
    suffixSum[n - 1] = piles[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + piles[i];
    }

    int dp[][] = new int[n][n];

    return mem(suffixSum, 0, 1, dp);
  }

  private int mem(int suffixSum[], int currInd, int m, int dp[][]) {

    if (currInd + 2 * m >= suffixSum.length)
      return suffixSum[currInd];

    if (dp[currInd][m] > 0)
      return dp[currInd][m];

    int res = Integer.MAX_VALUE;
    for (int i = 1; i <= 2 * m; i++) {
      res = Math.min(res, mem(suffixSum, currInd + i, Math.max(i, m), dp));
    }

    return dp[currInd][m] = suffixSum[currInd] - res;
  }
}

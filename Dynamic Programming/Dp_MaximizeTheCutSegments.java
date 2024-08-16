import java.util.Arrays;

public class Dp_MaximizeTheCutSegments {
  public int maximizeCuts(int n, int x, int y, int z) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);

    int res = mem(n, x, y, z, dp);

    return res < 0 ? 0 : res;
  }

  private int mem(int rodSize, int x, int y, int z, int dp[]) {

    if (rodSize == 0)
      return 0;

    if (rodSize < 0)
      return Integer.MIN_VALUE;

    if (dp[rodSize] != -1)
      return dp[rodSize];

    dp[rodSize] = 1 + Math.max(mem(rodSize - x, x, y, z, dp),
        Math.max(
            mem(rodSize - y, x, y, z, dp),
            mem(rodSize - z, x, y, z, dp)));
    return dp[rodSize];
  }
}

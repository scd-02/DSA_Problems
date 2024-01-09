public class Dp_MinimumStepsToMinimizeAsPerGivenCondition {
  /*
   * Given a number N, the task is to count minimum steps to minimize it to 1
   * according to the following criteria:
   * 
   * If N is divisible by 2 then you may reduce N to N/2.
   * If N is divisible by 3 then you may reduce N to N/3.
   * Otherwise, Decrement N by 1.
   */

  public int minSteps(int n) {
    if (n == 0 || n == 1)
      return 0;

    if (n == 2 || n == 3)
      return 1;

    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;

    for (int i = 4; i <= n; i++) {

      int div3 = Integer.MAX_VALUE;
      int div2 = Integer.MAX_VALUE;
      int inc1 = Integer.MAX_VALUE;

      if (i % 3 == 0) {
        div3 = dp[i / 3];
      }

      if (i % 2 == 0) {
        div2 = dp[i / 2];
      }

      inc1 = dp[i - 1];

      dp[i] = 1 + Math.min(Math.min(div2, div3), inc1);
    }

    return dp[n];
  }
}

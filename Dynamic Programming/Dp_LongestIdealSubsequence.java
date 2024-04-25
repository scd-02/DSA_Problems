public class Dp_LongestIdealSubsequence {
  public int longestIdealString(String s, int k) {
    // return= rec(0, s, -1, k);

    // int dp[][] = new int[s.length()][27];
    // for(int i = 0; i < dp.length; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(0, s, -1, k, dp);

    return tab(s, k);
  }

  public int rec(int i, String s, int prev, int k) {

    if (k < 0)
      return 0;

    if (i == s.length())
      return 0;

    int not_take = 0 + rec(i + 1, s, prev, k);

    int take = 0;

    if (prev == -1) {
      take = 1 + rec(i + 1, s, s.charAt(i) - 'a', k);
    } else if (Math.abs(prev - (s.charAt(i) - 'a')) <= k) {
      take = 1 + rec(i + 1, s, s.charAt(i) - 'a', k);
    }

    return Math.max(take, not_take);
  }

  public int mem(int i, String s, int prev, int k, int dp[][]) {

    if (k < 0)
      return 0;

    if (i == s.length())
      return 0;

    if (dp[i][prev + 1] != -1)
      return dp[i][prev + 1];

    int not_take = 0 + mem(i + 1, s, prev, k, dp);

    int take = 0;

    if (prev == -1) {
      take = 1 + mem(i + 1, s, s.charAt(i) - 'a', k, dp);
    } else if (Math.abs(prev - (s.charAt(i) - 'a')) <= k) {
      take = 1 + mem(i + 1, s, s.charAt(i) - 'a', k, dp);
    }

    return dp[i][prev + 1] = Math.max(take, not_take);
  }

  public int tab(String s, int k) {
    int N = s.length();
    int[] dp = new int[26];
    int res = 0;

    for (int i = 0; i < N; i++) {
      int curr = s.charAt(i) - 'a';
      int best = 0;
      for (int prev = 0; prev < 26; prev++) {
        if (Math.abs(prev - curr) <= k) {
          best = Math.max(best, dp[prev]);
        }
      }

      dp[curr] = Math.max(dp[curr], best + 1);
      res = Math.max(res, dp[curr]);
    }
    return res;
  }
}

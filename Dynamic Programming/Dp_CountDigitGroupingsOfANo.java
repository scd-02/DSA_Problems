import java.util.Arrays;

public class Dp_CountDigitGroupingsOfANo {
  public int TotalCount(String str) {
    int n = str.length();

    int dp[][] = new int[n][n * 9 + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    return countGrpMem(str.toCharArray(), 0, 0, n, dp);
  }

  public int countGrpMem(char str[], int pos, int prevSum, int n, int dp[][]) {

    if (pos == n) {
      return 1;
    }

    if (dp[pos][prevSum] != -1) {
      return dp[pos][prevSum];
    }

    dp[pos][prevSum] = 0;

    int res = 0;

    int sum = 0;

    for (int i = pos; i < n; i++) {

      sum += str[i] - '0';

      if (sum >= prevSum) {
        res += countGrpMem(str, i + 1, sum, n, dp);
      }
    }

    dp[pos][prevSum] = res;

    return dp[pos][prevSum];
  }

  public int countGrpRec(String str, int pos, int prevSum, int n) {

    if (pos == n) {
      return 1;
    }

    int res = 0;

    int sum = 0;

    for (int i = pos; i < n; i++) {

      sum += str.charAt(i) - '0';

      if (sum >= prevSum) {
        res += countGrpRec(str, i + 1, sum, n);
      }
    }

    return res;
  }
}

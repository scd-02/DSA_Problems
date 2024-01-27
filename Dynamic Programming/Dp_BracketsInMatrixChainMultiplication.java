public class Dp_BracketsInMatrixChainMultiplication {
  static String bracketOrder(int i, int j, char[] name, int bracket[][]) {
    String s = "";

    if (i == j) {
      s += name[0];
      name[0]++;

      return s;
    }

    s += "(";

    s += bracketOrder(i, bracket[i][j], name, bracket);
    s += bracketOrder(bracket[i][j] + 1, j, name, bracket);

    s += ")";

    return s;
  }

  static String matrixChainOrder(int p[], int n) {

    // storage of extra row and column is taken for our own convinience for easy
    // calculation
    int bracket[][] = new int[n][n];

    int dp[][] = new int[n][n];

    // matrix of length 1 will be 0
    for (int i = 1; i < n; i++) {
      dp[i][i] = 0;
    }

    for (int l = 2; l < n; l++) {

      for (int i = 1; i <= n - l; i++) {
        int j = i + l - 1;

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {

          int opr = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];

          if (opr < dp[i][j]) {
            dp[i][j] = opr;

            bracket[i][j] = k;
          }

        }
      }

    }

    return bracketOrder(1, n - 1, new char[] { 'A' }, bracket);
  }
}

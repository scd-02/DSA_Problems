public class Dp_KnapSackProblem {
  static int max(int a, int b) {
    return a > b ? a : b;
  }

  static int knapSack(int W, int wt[], int val[], int n) {
    int k[][] = new int[n + 1][W + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= W; w++) {
        if (i == 0 || w == 0) {
          k[i][w] = 0;
        } else if (wt[i - 1] > w) {
          k[i][w] = k[i - 1][w];
        } else {
          k[i][w] = max(k[i - 1][w], val[i - 1] + k[i - 1][w - wt[i - 1]]);
        }
      }
    }
    return k[n][W];
  }
}

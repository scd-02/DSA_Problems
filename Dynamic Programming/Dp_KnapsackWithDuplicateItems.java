public class Dp_KnapsackWithDuplicateItems {
  
  static int knapSack(int N, int W, int val[], int wt[]) {
    int prev[] = new int[W + 1];
    int curr[] = new int[W + 1];

    for (int w = 1; w <= W; w++) {
      for (int i = 0; i < N; i++) {

        if (w < wt[i]) {
          curr[w] = prev[w];
        } else {
          int excluded = prev[w];
          int included = val[i] + prev[w - wt[i]];
          int self = val[i] + curr[w - wt[i]];

          curr[w] = Math.max(Math.max(included, excluded), self);
        }

        prev = curr;
      }
    }

    return prev[W];
  }
}

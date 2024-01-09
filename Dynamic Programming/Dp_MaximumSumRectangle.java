public class Dp_MaximumSumRectangle {
  int maximumSumRectangle(int R, int C, int M[][]) {

    int maxSum = Integer.MIN_VALUE;

    for (int ri = 0; ri < R; ri++) {

      int temp[] = new int[C];
      int currSum = 0;

      for (int rj = ri; rj < R; rj++) {

        for (int c = 0; c < C; c++) {
          temp[c] = temp[c] + M[rj][c];
        }

        currSum = kadanesAlgo(temp);
        maxSum = Math.max(maxSum, currSum);
      }

    }

    return maxSum;

  }

  int kadanesAlgo(int a[]) {

    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;

    for (int i = 0; i < a.length; i++) {

      currSum += a[i];

      maxSum = Math.max(maxSum, currSum);

      currSum = currSum < 0 ? 0 : currSum;

    }

    return maxSum;
  }
}

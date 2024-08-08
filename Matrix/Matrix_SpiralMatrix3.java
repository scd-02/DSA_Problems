public class Matrix_SpiralMatrix3 {
  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

    int ans[][] = new int[rows * cols][2];

    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int index = 0;

    for (int step = 1, direction = 0; index < rows * cols;) {

      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < step; j++) {
          if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
            ans[index][0] = rStart;
            ans[index][1] = cStart;
            index++;
          }

          rStart += dir[direction][0];
          cStart += dir[direction][1];
        }

        direction = (direction + 1) % 4;
      }

      step++;
    }

    return ans;
  }
}

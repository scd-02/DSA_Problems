public class Bit_ScoreAfterFlippingMatrix {
  public int matrixScore(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;

    // row modification
    for (int i = 0; i < m; i++) {
      if (grid[i][0] != 1) {
        for (int j = 0; j < n; j++) {
          grid[i][j] ^= 1;
        }
      }
    }

    // column modification except first coulumn
    for (int j = 1; j < n; j++) {

      int count0 = 0;
      for (int i = 0; i < m; i++) {
        if (grid[i][j] == 0) {
          count0++;
        }
      }

      if (count0 > m - count0) {
        for (int i = 0; i < m; i++) {
          grid[i][j] ^= 1;
        }
      }
    }

    // calculate score
    int score = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int rowScore = grid[i][j] << (n - j - 1);
        score += rowScore;
      }
    }

    return score;
  }
}

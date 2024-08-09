public class Matrix_MagicSquaresInGrid {
  public int numMagicSquaresInside(int[][] grid) {
    int ans = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int row = 0; row + 2 < m; row++) {
      for (int col = 0; col + 2 < n; col++) {
        if (isMagicSquare(grid, row, col)) {
          ans++;
        }
      }
    }
    return ans;
  }

  private boolean isMagicSquare(int[][] grid, int row, int col) {

    // unique constraint
    boolean visited[] = new boolean[10];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {

        int ele = grid[row + i][col + j];

        if (ele < 1 || ele > 9)
          return false;
        if (visited[ele])
          return false;

        visited[ele] = true;
      }
    }

    // check if diagonal sums are same value
    int diagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
    int diagonal2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

    if (diagonal1 != diagonal2)
      return false;

    // check if row sums are same value
    for (int i = 0; i < 3; i++) {
      int rowSum = 0, colSum = 0;

      for (int j = 0; j < 3; j++) {
        rowSum += grid[row + i][col + j];
        colSum += grid[row + j][col + i];
      }

      if (rowSum != diagonal1)
        return false;
      if (colSum != diagonal1)
        return false;
    }

    return true;
  }
}

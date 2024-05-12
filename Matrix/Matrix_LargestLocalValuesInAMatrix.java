public class Matrix_LargestLocalValuesInAMatrix {
  public int[][] largestLocal(int[][] grid) {

    int n = grid.length;
    int ans[][] = new int[n - 2][n - 2];

    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < n - 2; j++) {
        ans[i][j] = max3X3(grid, i, j);
      }
    }

    return ans;
  }

  public int max3X3(int[][] grid, int r, int c) {

    int max = 0;
    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        max = Math.max(grid[i][j], max);
      }
    }
    return max;
  }
}

public class Graph_countSubIslands {
  private final int[][] directions = {
      { 0, 1 },
      { 1, 0 },
      { 0, -1 },
      { -1, 0 }
  };

  private boolean isLand(int x, int y, int grid[][]) {
    return grid[x][y] == 1;
  }

  private boolean isSubIsland(int grid1[][], int grid2[][], int x, int y, boolean visited[][]) {

    boolean isSubIsland = true;

    if (!isLand(x, y, grid1)) {
      isSubIsland = false;
    }

    for (int[] direction : directions) {
      int newX = direction[0] + x;
      int newY = direction[1] + y;

      if (newX >= 0 && newX < grid2.length &&
          newY >= 0 && newY < grid2[0].length &&
          !visited[newX][newY] &&
          isLand(newX, newY, grid2)) {
        visited[newX][newY] = true;
        boolean nextCellIsSubIsland = isSubIsland(grid1, grid2, newX, newY, visited);
        isSubIsland = isSubIsland && nextCellIsSubIsland;
      }
    }

    return isSubIsland;
  }

  public int countSubIslands(int[][] grid1, int[][] grid2) {

    int row = grid2.length, col = grid2[0].length;
    boolean visited[][] = new boolean[row][col];

    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (!visited[i][j] && isLand(i, j, grid2)) {
          visited[i][j] = true;
          if (isSubIsland(grid1, grid2, i, j, visited)) {
            count++;
          }
        }
      }
    }

    return count;
  }
}

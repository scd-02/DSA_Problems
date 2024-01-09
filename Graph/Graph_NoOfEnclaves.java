public class Graph_NoOfEnclaves {
  int numberOfEnclaves(int[][] grid) {

    int n = grid.length;
    int m = grid[0].length;

    // for 1st column
    for (int i = 0; i < n; i++) {

      int j = 0;

      if (grid[i][j] == 1) {
        dfs(grid, i, j, n, m, 2);
      }

    }

    // for last column
    for (int i = 0; i < n; i++) {

      int j = m - 1;

      if (grid[i][j] == 1) {
        dfs(grid, i, j, n, m, 2);
      }

    }

    // for first row
    for (int j = 0; j < m; j++) {

      int i = 0;

      if (grid[i][j] == 1) {
        dfs(grid, i, j, n, m, 2);
      }

    }

    // for last row
    for (int j = 0; j < m; j++) {

      int i = n - 1;

      if (grid[i][j] == 1) {
        dfs(grid, i, j, n, m, 2);
      }

    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (grid[i][j] == 1)
          count++;
      }
    }

    return count;
  }

  static void dfs(int[][] grid, int cr, int cc, int n, int m, int visited) {

    if (cr >= n || cr < 0 || cc >= m || cc < 0)
      return;

    if (grid[cr][cc] == 0 || grid[cr][cc] == visited)
      return;

    grid[cr][cc] = visited;

    dfs(grid, cr + 1, cc, n, m, visited);
    dfs(grid, cr - 1, cc, n, m, visited);
    dfs(grid, cr, cc + 1, n, m, visited);
    dfs(grid, cr, cc - 1, n, m, visited);

  }
}

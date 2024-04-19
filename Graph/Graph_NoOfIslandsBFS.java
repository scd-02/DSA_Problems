import java.util.LinkedList;
import java.util.Queue;

public class Graph_NoOfIslandsBFS {
  public int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int visited[][] = new int[row][col];
    int ans = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1' && visited[i][j] == 0) {
          bfs(grid, i, j, row, col, visited);
          ans++;
        }
      }
    }

    return ans;
  }

  public void bfs(char grid[][], int i, int j, int row, int col, int visited[][]) {

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(i, j));

    visited[i][j] = 1;

    int dx[] = { -1, 0, 1, 0 };
    int dy[] = { 0, 1, 0, -1 };
    while (!q.isEmpty()) {
      Pair p = q.poll();
      int x = p.x;
      int y = p.y;

      for (int d = 0; d < 4; d++) {
        int newX = x + dx[d];
        int newY = y + dy[d];

        if (newX >= 0 && newX < row && newY >= 0 && newY < col &&
            grid[newX][newY] == '1' &&
            visited[newX][newY] == 0) {

          visited[newX][newY] = 1;
          q.add(new Pair(newX, newY));
        }
      }
    }

  }

  class Pair {
    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

import java.util.LinkedList;
import java.util.Queue;

public class Graph_DistanceOfNearestCellHaving1 {
  public int[][] nearest(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<Pair> q = new LinkedList<>();
    boolean visited[][] = new boolean[m][n];
    int ans[][] = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          q.add(new Pair(0, i, j));
          visited[i][j] = true;
        }
      }
    }

    while (!q.isEmpty()) {

      Pair p = q.poll();
      int val = p.val;
      int x = p.i;
      int y = p.j;

      ans[x][y] = val;

      if (x - 1 >= 0 && !visited[x - 1][y]) {
        q.add(new Pair(val + 1, x - 1, y));
        visited[x - 1][y] = true;
      }

      if (x + 1 < m && !visited[x + 1][y]) {
        q.add(new Pair(val + 1, x + 1, y));
        visited[x + 1][y] = true;
      }

      if (y - 1 >= 0 && !visited[x][y - 1]) {
        q.add(new Pair(val + 1, x, y - 1));
        visited[x][y - 1] = true;
      }

      if (y + 1 < n && !visited[x][y + 1]) {
        q.add(new Pair(val + 1, x, y + 1));
        visited[x][y + 1] = true;
      }
    }
    return ans;
  }

  class Pair {

    int val;
    int i, j;

    Pair(int val, int i, int j) {
      this.val = val;
      this.i = i;
      this.j = j;
    }
  }
}

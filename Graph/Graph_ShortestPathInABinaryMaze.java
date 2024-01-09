import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_ShortestPathInABinaryMaze {
  int shortestPath(int[][] grid, int[] source, int[] destination) {

    int n = grid.length;
    int m = grid[0].length;

    int sx = source[0], sy = source[1];
    int dx = destination[0], dy = destination[1];

    // edge case
    if (sx == dx && sy == dy)
      return 0;
    if (grid[dx][dy] == 0)
      return -1;

    // Djikstra's algorithm for shortest path
    int distance[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }

    distance[sx][sy] = 0;

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(0, sx, sy));

    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, 1, 0, -1 };

    while (!q.isEmpty()) {

      Pair p = q.poll();
      int x = p.u;
      int y = p.v;
      int w = p.w;

      for (int i = 0; i < 4; i++) {
        int newx = x + dirx[i];
        int newy = y + diry[i];

        if (newx >= 0 && newx < n && newy >= 0 && newy < m
            && grid[newx][newy] == 1
            && w + 1 < distance[newx][newy]) {

          distance[newx][newy] = w + 1;
          if (newx == dx && newy == dy) {
            return w + 1;
          }
          q.add(new Pair(w + 1, newx, newy));
        }
      }
    }

    return -1;
  }

  class Pair {
    int w;
    int u;
    int v;

    Pair(int w, int u, int v) {
      this.w = w;
      this.u = u;
      this.v = v;
    }
  }
}

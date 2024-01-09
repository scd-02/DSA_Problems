import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph_PathWithMinimumEffort {
  class Pair {
    int w;
    int x;
    int y;

    Pair(int w, int x, int y) {
      this.w = w;
      this.x = x;
      this.y = y;
    }
  }

  int MinimumEffort(int heights[][]) {

    int n = heights.length;
    int m = heights[0].length;

    int efforts[][] = new int[n][m];

    for (int i = 0; i < n; i++) {
      Arrays.fill(efforts[i], Integer.MAX_VALUE);
    }

    efforts[0][0] = 0;

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.w - b.w);
    q.add(new Pair(0, 0, 0));

    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, 1, 0, -1 };

    while (!q.isEmpty()) {

      Pair p = q.poll();
      int x = p.x;
      int y = p.y;
      int effort = p.w;

      if (x == n - 1 && y == m - 1)
        return effort;

      for (int i = 0; i < 4; i++) {
        int newx = x + dirx[i];
        int newy = y + diry[i];

        if (newx >= 0 && newx < n && newy >= 0 && newy < m) {

          int diff = Math.abs(heights[x][y] - heights[newx][newy]);
          int newEffort = Math.max(diff, effort);

          if (newEffort < efforts[newx][newy]) {
            q.add(new Pair(newEffort, newx, newy));
            efforts[newx][newy] = newEffort;
          }
        }

      }
    }

    return 0;
  }
}

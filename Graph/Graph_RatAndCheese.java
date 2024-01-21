import java.util.LinkedList;
import java.util.Queue;

public class Graph_RatAndCheese {

  static class Pair {
    int x;
    int y;
    int time;

    Pair(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }

  public static int solve(int matrix[][], int n, int m) {

    Queue<Pair> q = new LinkedList<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 2) {
          q.add(new Pair(i, j, 0));
        }
      }
    }

    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, 1, 0, -1 };

    int ans = 0;

    while (!q.isEmpty()) {

      Pair u = q.poll();

      int x = u.x;
      int y = u.y;
      int move = u.time;

      for (int i = 0; i < 4; i++) {
        int nx = x + dirx[i];
        int ny = y + diry[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] == 1) {
          q.add(new Pair(nx, ny, move + 1));
          matrix[nx][ny] = 3;
        }
      }

      ans = Math.max(ans, move);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          return -1;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int matrix[][] = {
        { 2, 1, 1 },
        { 0, 1, 1 },
        { 1, 0, 1 }
    };
    System.out.println(solve(matrix, matrix.length, matrix[0].length));
  }
}

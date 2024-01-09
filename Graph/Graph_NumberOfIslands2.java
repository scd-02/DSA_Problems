import java.util.ArrayList;
import java.util.List;

public class Graph_NumberOfIslands2 {
  class DSU {

    int parent[];
    int rank[];

    DSU(int v) {
      parent = new int[v];
      rank = new int[v];

      for (int i = 0; i < v; i++) {
        parent[i] = i;
      }
    }

    int find(int x) {

      if (parent[x] == x) {
        return x;
      }

      return parent[x] = find(parent[x]);
    }

    void unionByRank(int x, int y) {
      int up_x = find(x);
      int up_y = find(y);

      if (up_x == up_y)
        return;

      if (rank[up_x] < rank[up_y]) {
        parent[up_x] = up_y;
      } else if (rank[up_x] > rank[up_y]) {
        parent[up_y] = up_x;
      } else {
        parent[up_y] = up_x;
        rank[up_x] += 1;
      }
    }
  }

  public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

    List<Integer> ans = new ArrayList<>();

    DSU dsu = new DSU(rows * cols);
    int island[][] = new int[rows][cols];

    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, 1, 0, -1 };

    int count = 0;

    for (int i = 0; i < operators.length; i++) {

      int r = operators[i][0];
      int c = operators[i][1];

      if (island[r][c] == 1) {
        ans.add(count);
        continue;
      }

      island[r][c] = 1;
      count++;

      for (int d = 0; d < 4; d++) {
        int adjr = r + dirx[d];
        int adjc = c + diry[d];

        if (adjr >= 0 && adjr < rows && adjc >= 0 && adjc < cols && island[adjr][adjc] == 1) {
          int currNode = r * cols + c;
          int adjNode = adjr * cols + adjc;

          if (dsu.find(currNode) != dsu.find(adjNode)) {
            dsu.unionByRank(currNode, adjNode);
            count--;
          }
        }
      }

      ans.add(count);
    }

    return ans;
  }
}

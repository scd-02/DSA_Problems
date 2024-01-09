import java.util.HashSet;

public class Graph_MaximumConnectedGroup {
  class DSU {

    int parent[];
    int size[];

    DSU(int v) {
      parent = new int[v];
      size = new int[v];

      for (int i = 0; i < v; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    int find(int x) {

      if (parent[x] == x) {
        return x;
      }

      return parent[x] = find(parent[x]);
    }

    void unionBySize(int x, int y) {
      int up_x = find(x);
      int up_y = find(y);

      if (up_x == up_y)
        return;

      if (size[up_x] < size[up_y]) {
        parent[up_x] = up_y;
        size[up_y] += size[up_x];
      } else {
        parent[up_y] = up_x;
        size[up_x] += size[up_y];
      }

    }
  }

  public int MaxConnection(int grid[][]) {

    int n = grid.length;

    DSU dsu = new DSU(n * n);

    int dirx[] = { -1, 0, 1, 0 };
    int diry[] = { 0, 1, 0, -1 };

    // forming components i.e. all possible group of islands
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (grid[i][j] == 0)
          continue;

        for (int k = 0; k < 4; k++) {
          int adjr = i + dirx[k];
          int adjc = j + diry[k];

          if (isValid(adjr, adjc, n) && grid[adjr][adjc] == 1) {
            int node = i * n + j;
            int adjNode = adjr * n + adjc;

            dsu.unionBySize(node, adjNode);
          }
        }

      }
    }

    // changing state of each 0 and finding larger group of islands
    int maxIsland = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (grid[i][j] == 1)
          continue;

        HashSet<Integer> components = new HashSet<>();

        for (int k = 0; k < 4; k++) {
          int adjr = i + dirx[k];
          int adjc = j + diry[k];

          if (isValid(adjr, adjc, n) && grid[adjr][adjc] == 1) {
            int adjNode = adjr * n + adjc;

            components.add(dsu.find(adjNode));
          }
        }

        int size = 1;
        for (Integer it : components) {
          size += dsu.size[it];
        }

        maxIsland = Math.max(maxIsland, size);
      }
    }

    // to check if all the cells are 1
    for (int i = 0; i < n * n; i++) {
      maxIsland = Math.max(maxIsland, dsu.size[i]);
    }

    return maxIsland;
  }

  boolean isValid(int r, int c, int n) {
    return r >= 0 && r < n && c >= 0 && c < n;
  }
}

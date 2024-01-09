public class Graph_ConnectingTheGraph {
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

  public int Solve(int n, int[][] edge) {

    int m = edge.length;

    if (m < n - 1)
      return -1;

    DSU dsu = new DSU(n);

    for (int i = 0; i < m; i++) {
      dsu.unionByRank(edge[i][0], edge[i][1]);
    }

    int opr = 0;
    for (int i = 1; i < n; i++) {
      if (dsu.find(0) != dsu.find(i)) {
        dsu.unionByRank(0, i);
        opr++;
      }
    }

    return opr;
  }
}

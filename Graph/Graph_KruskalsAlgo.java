import java.util.PriorityQueue;

public class Graph_KruskalsAlgo {

  static class DSU {

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

  static class Pair {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }
  }

  static int spanningTree(int V, int E, int edges[][]) {

    DSU dsu = new DSU(V);

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.wt - b.wt);

    for (int i = 0; i < E; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      q.add(new Pair(u, v, w));
    }

    int sum = 0;
    while (!q.isEmpty()) {

      Pair p = q.poll();
      int u = p.u;
      int v = p.v;
      int ew = p.wt;

      int p_u = dsu.find(u);
      int p_v = dsu.find(v);

      if (p_u == p_v) {
        continue;
      } else {
        dsu.unionByRank(u, v);
        sum += ew;
      }

    }

    return sum;
  }
}

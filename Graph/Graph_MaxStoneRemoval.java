import java.util.HashSet;
import java.util.Iterator;

public class Graph_MaxStoneRemoval {
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

  int maxRemove(int[][] stones, int n) {

    int maxRow = 0, maxCol = 0;

    for (int i = 0; i < n; i++) {
      maxRow = Math.max(maxRow, stones[i][0]);
      maxCol = Math.max(maxCol, stones[i][1]);
    }

    DSU dsu = new DSU(maxRow + maxCol + 2);
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {

      int u = stones[i][0];
      int v = stones[i][1] + maxRow + 1;

      dsu.unionByRank(u, v);

      set.add(u);
      set.add(v);
    }

    Iterator<Integer> it = set.iterator();

    int component = 0;
    while (it.hasNext()) {

      int x = it.next();

      if (dsu.find(x) == x)
        component++;

    }

    return n - component;
  }
}

public class Graph_DSU_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
  public int maxNumEdgesToRemove(int n, int[][] edges) {

    UnionFind alice = new UnionFind(n);
    UnionFind bob = new UnionFind(n);

    int importantEdges = 0;

    // process type 3 edge first as it is most important
    for (int edge[] : edges) {
      if (edge[0] == 3) {
        importantEdges += Math.max(bob.union(edge[1], edge[2]), alice.union(edge[1], edge[2]));
      }
    }

    // process type 2 or type 1 edge if they contribute towared connectedness of
    // components
    for (int edge[] : edges) {
      if (edge[0] == 1) {
        importantEdges += alice.union(edge[1], edge[2]);
      } else if (edge[0] == 2) {
        importantEdges += bob.union(edge[1], edge[2]);
      }
    }

    if (alice.isConnected() && bob.isConnected()) {
      return edges.length - importantEdges;
    }

    return -1;
  }

  class UnionFind {

    int parent[];
    int size[];
    int components;

    UnionFind(int n) {
      components = n;
      parent = new int[n + 1];
      size = new int[n + 1];

      for (int i = 0; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    int findParent(int x) {

      if (parent[x] == x) {
        return x;
      }
      return parent[x] = findParent(parent[x]);
    }

    int union(int x, int y) {

      x = findParent(x);
      y = findParent(y);

      if (x == y)
        return 0;

      if (size[x] > size[y]) {
        parent[y] = x;
        size[x] += size[y];
      } else {
        parent[x] = y;
        size[y] += size[x];
      }

      components--;
      return 1;
    }

    boolean isConnected() {
      return components == 1;
    }
  }

}

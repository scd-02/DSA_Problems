public class Graph_DSU_FindIfPathExistsInGraph {
  class DisJointSet {
    int parent[];
    int size[];

    DisJointSet(int n) {
      parent = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    int findUlp(int i) {
      if (parent[i] == i)
        return i;
      return parent[i] = findUlp(parent[i]);
    }

    void unionBySize(int u, int v) {
      int ulp_u = findUlp(u);
      int ulp_v = findUlp(v);
      if (ulp_u == ulp_v)
        return;
      if (size[ulp_u] > size[ulp_v]) {
        size[ulp_u] += size[ulp_v];
        parent[ulp_v] = ulp_u;
      } else {
        size[ulp_v] += size[ulp_u];
        parent[ulp_u] = ulp_v;
      }
    }
  }

  class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      DisJointSet ob = new DisJointSet(n);
      for (int edge[] : edges) {
        ob.unionBySize(edge[0], edge[1]);
      }
      if (ob.findUlp(source) == ob.findUlp(destination))
        return true;
      return false;
    }
  }
}

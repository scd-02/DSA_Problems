import java.util.ArrayList;
import java.util.HashSet;

public class Graph_DSU_DetectCycleUsingDSU {

  // Function to detect cycle using DSU in an undirected graph.
  public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    DSU uf = new DSU(V);
    HashSet<String> hs = new HashSet<>();

    for (int u = 0; u < V; u++) {
      for (int v : adj.get(u)) {

        if (hs.contains(pair(u, v))) {
          continue;
        }

        if (uf.find(u) != uf.find(v)) {
          uf.union(u, v);
          hs.add(pair(u, v));
          hs.add(pair(v, u));
        } else {
          return 1;
        }
      }
    }

    return 0;
  }

  static String pair(int x, int y) {
    return Integer.toString(x) + Integer.toString(y);
  }
}

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

  void union(int x, int y) {

    int parentX = find(x);
    int parentY = find(y);

    if (parentX == parentY) {
      return;
    }

    if (rank[parentX] < rank[parentY]) {
      parent[parentX] = parentY;
    } else if (rank[parentX] > rank[parentY]) {
      parent[parentY] = parentX;
    } else {
      parent[parentY] = parentX;
      rank[parentX] = rank[parentX] + 1;
    }

  }
}
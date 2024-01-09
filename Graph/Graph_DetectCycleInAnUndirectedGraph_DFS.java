import java.util.ArrayList;

public class Graph_DetectCycleInAnUndirectedGraph_DFS {

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {

      if (!visited[i]) {
        if (dfs(i, -1, visited, adj))
          return true;
      }
    }

    return false;
  }

  public boolean dfs(int u, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj) {

    visited[u] = true;

    for (int v : adj.get(u)) {

      if (visited[v] == false) {

        if (dfs(v, u, visited, adj))
          return true;

      } else if (v != parent)
        return true;

    }

    return false;
  }
}

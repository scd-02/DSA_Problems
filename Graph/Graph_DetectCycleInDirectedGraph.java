import java.util.ArrayList;

public class Graph_DetectCycleInDirectedGraph {
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

    boolean visited[] = new boolean[V];

    boolean pathVisited[] = new boolean[V];

    for (int i = 0; i < V; V++) {
      if (!visited[i]) {
        if (dfs(i, visited, pathVisited, adj))
          return true;
      }
    }

    return false;
  }

  public boolean dfs(int u, boolean visited[], boolean pathVisited[], ArrayList<ArrayList<Integer>> adj) {

    visited[u] = true;
    pathVisited[u] = true;

    for (int v : adj.get(u)) {

      if (!visited[v]) {

        if (dfs(v, visited, pathVisited, adj) == true)
          return true;

      } else if (pathVisited[v] == true) {
        return true;
      }

    }

    pathVisited[u] = false;
    return false;
  }
}

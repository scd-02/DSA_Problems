import java.util.List;

public class Graph_EulerCircuitAndPath {
  /*
   * 
   * An Eulerian Path is a path in graph that visits every edge exactly once and
   * it starts and ends up at different indexes.
   * An Eulerian Circuit is an Eulerian Path which starts and ends on the same
   * vertex.
   * Given an undirected acyclic graph with V nodes, and E edges, with adjacency
   * list adj, return 2 if the graph contains an eulerian circuit, else if the
   * graph contains an eulerian path, return 1, otherwise, return 0.
   * 
   */
  public int isEulerCircuit(int V, List<Integer>[] adj) {
    if (!isConnected(V, adj))
      return 0;

    int odd = 0;

    for (int i = 0; i < V; i++) {

      if (adj[i].size() % 2 != 0)
        odd++;

    }

    if (odd > 2)
      return 0;

    return (odd == 2) ? 1 : 2;

  }

  public boolean isConnected(int v, List<Integer>[] adj) {

    boolean visited[] = new boolean[v];

    // find a node with non zero degree
    int i;
    for (i = 0; i < v; i++) {

      if (adj[i].size() != 0)
        break;

    }

    if (i == v)
      return true;

    dfs(i, visited, adj);

    for (i = 0; i < v; i++) {

      if (visited[i] == false && adj[i].size() != 0)
        return false;

    }

    return true;
  }

  public void dfs(int u, boolean visited[], List<Integer>[] adj) {

    visited[u] = true;

    for (int v : adj[u]) {

      if (visited[v] == false) {
        dfs(v, visited, adj);
      }
    }
  }
}

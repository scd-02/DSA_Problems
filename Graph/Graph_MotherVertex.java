import java.util.ArrayList;
import java.util.Arrays;

public class Graph_MotherVertex {
  public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {

    // DFS
    int visited[] = new int[V];
    int probableMV = -1;

    for (int i = 0; i < V; i++) {

      if (visited[i] == 0) {
        dfs(visited, i, adj);
        probableMV = i;
      }

    }

    Arrays.fill(visited, 0);

    dfs(visited, probableMV, adj);

    for (int e : visited) {
      if (e == 0)
        return -1;
    }

    return probableMV;
  }

  public void dfs(int[] visited, int u, ArrayList<ArrayList<Integer>> adj) {

    visited[u] = 1;

    for (int v = 0; v < adj.get(u).size(); v++) {

      if (visited[adj.get(u).get(v)] == 0) {
        dfs(visited, adj.get(u).get(v), adj);
      }

    }

  }
}

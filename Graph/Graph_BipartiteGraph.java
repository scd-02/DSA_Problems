import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BipartiteGraph {
  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

    int color[] = new int[V];
    Arrays.fill(color, -1);

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        // if (bfs(i, color, adj) == false)
        // return false;
        if (dfs(i, 0, color, adj) == false)
          return false;

      }
    }

    return true;
  }

  public boolean dfs(int u, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {

    color[u] = col;

    for (int v : adj.get(u)) {

      if (color[v] == -1) {

        if (dfs(v, 1 - col, color, adj) == false)
          return false;

      } else if (col == color[v]) {
        return false;
      }

    }

    return true;
  }

  public boolean bfs(int node, int color[], ArrayList<ArrayList<Integer>> adj) {

    Queue<Integer> q = new LinkedList<>();
    q.add(node);

    color[node] = 1;

    while (!q.isEmpty()) {

      int u = q.poll();

      for (int v : adj.get(u)) {

        if (color[v] == -1) {
          q.add(v);
          color[v] = (color[u] == 1) ? 2 : 1;
        } else if (color[v] == color[u]) {
          return false;
        }

      }

    }

    return true;
  }
}

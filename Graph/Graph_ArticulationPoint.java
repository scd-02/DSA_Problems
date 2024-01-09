import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Graph_ArticulationPoint {
  public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
    int tin[] = new int[V];
    int low[] = new int[V];
    int visited[] = new int[V];

    HashSet<Integer> hs = new HashSet<>();

    dfs(0, -1, visited, tin, low, adj, hs);

    ArrayList<Integer> ans = new ArrayList<>(hs);

    if (ans.size() == 0) {
      ans.add(-1);
    }

    Collections.sort(ans);
    return ans;
  }

  int timer = 0;

  public void dfs(int u, int parent, int[] visited, int[] tin, int[] low,
      ArrayList<ArrayList<Integer>> adj,
      HashSet<Integer> hs) {

    visited[u] = 1;
    tin[u] = low[u] = timer;
    timer++;

    int child = 0;

    for (int v : adj.get(u)) {

      if (v == parent)
        continue;

      if (visited[v] == 0) {

        dfs(v, u, visited, tin, low, adj, hs);

        low[u] = Math.min(low[u], low[v]);

        if (tin[u] <= low[v] && parent != -1) {
          hs.add(u);
        }

        child++;
      } else {
        low[u] = Math.min(tin[v], low[u]);
      }

    }

    if (child > 1 && parent == -1) {
      hs.add(u);
    }
  }
}

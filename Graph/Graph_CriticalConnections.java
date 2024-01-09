import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Graph_CriticalConnections {
  int timer = 1;

  public ArrayList<ArrayList<Integer>> criticalConnections(int V, ArrayList<ArrayList<Integer>> adj) {

    int visited[] = new int[V];
    int tin[] = new int[V]; // time of insertion

    int low[] = new int[V];

    ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
    dfs(0, -1, visited, tin, low, adj, bridges);

    for (int i = 0; i < bridges.size(); i++) {
      Collections.sort(bridges.get(i));
    }

    Collections.sort(bridges, new Comparator<ArrayList<Integer>>() {
      public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {

        int x = a.get(0) - b.get(0);
        int y = a.get(1) - b.get(1);

        return x == 0 ? y : x;
      }
    });

    return bridges;
  }

  public void dfs(int u, int parent, int visited[], int tin[], int low[],
      ArrayList<ArrayList<Integer>> adj,
      ArrayList<ArrayList<Integer>> bridges) {

    visited[u] = 1;
    tin[u] = low[u] = timer;
    timer++;

    for (int v : adj.get(u)) {

      if (v == parent)
        continue;

      if (visited[v] == 1) {
        low[u] = Math.min(low[v], low[u]);
      } else {

        dfs(v, u, visited, tin, low, adj, bridges);

        low[u] = Math.min(low[v], low[u]);

        // trying to remove the edge to consider it as bridge
        if (tin[u] < low[v]) {
          ArrayList<Integer> temp = new ArrayList<>();
          temp.add(u);
          temp.add(v);
          bridges.add(temp);
        }

      }

    }
  }
}

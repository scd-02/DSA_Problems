import java.util.ArrayList;

public class Graph_IsItATree {
  public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
    int visited[] = new int[n];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int u = edges.get(i).get(0);
      int v = edges.get(i).get(1);

      if (u == v) {
        return false;
      }

      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    boolean ans = !isCycle(adj, visited, 0, -1);

    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        return false;
      }
    }

    return ans;
  }

  public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int visited[], int u, int parent) {

    visited[u] = 1;

    for (int v : adj.get(u)) {
      if (visited[v] == 0) {
        if (isCycle(adj, visited, v, u)) {
          return true;
        }
      } else {
        if (v != parent)
          return true;
      }
    }

    return false;
  }
}

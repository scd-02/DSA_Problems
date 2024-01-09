import java.util.ArrayList;

public class Graph_FindNoOfConnectedComponents {
  static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {

    boolean visited[] = new boolean[v];
    int count = 0;

    for (int i = 0; i < v; i++) {
      if (!visited[i]) {
        findProvince(adj, i, visited, v);
        count++;
      }
    }

    return count;
  }

  static void findProvince(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[], int vertices) {

    visited[u] = true;

    for (int v = 0; v < vertices; v++) {
      if (!visited[v] && adj.get(u).get(v) == 1) {
        findProvince(adj, v, visited, vertices);
      }
    }

  }
}

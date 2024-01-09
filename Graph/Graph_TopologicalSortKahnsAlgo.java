import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_TopologicalSortKahnsAlgo {
  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

    int ans[] = new int[V];

    int indegree[] = new int[V];

    for (int i = 0; i < V; i++) {
      for (int v : adj.get(i)) {
        indegree[v]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int u = 0; u < V; u++) {
      if (indegree[u] == 0) {
        q.add(u);
      }
    }

    int i = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      ans[i++] = u;

      for (int v : adj.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.add(v);
        }
      }
    }

    return ans;
  }
}

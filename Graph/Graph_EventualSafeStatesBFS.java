import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_EventualSafeStatesBFS {
  List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

    ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      revAdj.add(new ArrayList<>());
    }

    int indegree[] = new int[V];

    for (int u = 0; u < V; u++) {
      for (int v : adj.get(u)) {
        revAdj.get(v).add(u);
        indegree[u]++;
      }
    }

    List<Integer> safe = new ArrayList<>();
    topoSort(V, revAdj, safe, indegree);

    Collections.sort(safe);
    return safe;
  }

  public void topoSort(int V, ArrayList<ArrayList<Integer>> adj, List<Integer> safe, int indegree[]) {

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {

      int u = q.poll();
      safe.add(u);

      for (int v : adj.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.add(v);
        }
      }

    }
  }
}

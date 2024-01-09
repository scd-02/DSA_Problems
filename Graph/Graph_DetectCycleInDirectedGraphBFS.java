import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_DetectCycleInDirectedGraphBFS {
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

    int indegree[] = new int[V];

    for (int u = 0; u < V; u++) {
      for (int v : adj.get(u)) {
        indegree[v]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < V; i++) {

      if (indegree[i] == 0) {
        q.add(i);
      }

    }

    ArrayList<Integer> topo = new ArrayList<>();
    while (!q.isEmpty()) {

      int u = q.poll();

      topo.add(u);
      for (int v : adj.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.add(v);
        }
      }

    }

    return topo.size() == V ? false : true;
  }
}

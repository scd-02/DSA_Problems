import java.util.ArrayList;
import java.util.List;

public class Graph_EventualSafeStates {
  List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

    int visited[] = new int[V];
    int pathVisited[] = new int[V];
    int safe[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] == 0) {
        cycleDetectDFS(i, visited, pathVisited, safe, adj);
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      if (safe[i] == 1) {
        ans.add(i);
      }
    }

    return ans;
  }

  public boolean cycleDetectDFS(int u, int visited[], int pathVisited[], int safe[], List<List<Integer>> adj) {

    visited[u] = 1;
    pathVisited[u] = 1;

    for (int v : adj.get(u)) {

      if (visited[v] == 0) {
        if (cycleDetectDFS(v, visited, pathVisited, safe, adj)) {
          return true;
        }
      } else if (pathVisited[v] == 1) {
        return true;
      }

    }

    pathVisited[u] = 0;
    safe[u] = 1;

    return false;
  }
}

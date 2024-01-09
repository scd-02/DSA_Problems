import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Graph_DetectCycleInAnUndirectedGraph_BFS {
  class Pair {
    int curr, par;

    Pair(int curr, int par) {
      this.curr = curr;
      this.par = par;
    }
  }

  // Function to detect cycle in an undirected graph.
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {

      if (!visited[i]) {
        if (bfs(i, visited, adj))
          return true;
      }
    }

    return false;
  }

  public boolean bfs(int s, boolean visited[], ArrayList<ArrayList<Integer>> adj) {

    Queue<Pair> q = new LinkedList<>();

    q.add(new Pair(s, -1));
    visited[s] = true;

    while (!q.isEmpty()) {

      Pair p = q.poll();

      int u = p.curr;
      int par = p.par;

      for (int v : adj.get(u)) {

        if (visited[v] == false) {
          q.add(new Pair(v, u));
          visited[v] = true;
        } else if (v != par) {
          return true;
        }
      }

    }

    return false;
  }
}

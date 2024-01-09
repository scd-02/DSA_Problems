import java.util.ArrayList;
import java.util.Stack;

public class Graph_KosarajuAlgo {
  /*
   * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
   * Find the number of strongly connected components in the graph.
   */

  public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

    // sort the edges according to finish time - topological sort
    Stack<Integer> stk = new Stack<>();
    int topoVis[] = new int[V];

    for (int i = 0; i < V; i++) {
      if (topoVis[i] == 0) {
        toposort(i, topoVis, stk, adj);
      }
    }

    // reverse the edges of graph
    ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      revAdj.add(new ArrayList<>());
    }

    for (int i = 0; i < V; i++) {
      for (int v : adj.get(i)) {
        revAdj.get(v).add(i);
      }
    }

    int visited[] = new int[V];
    int count = 0;

    while (!stk.isEmpty()) {
      int x = stk.pop();

      if (visited[x] == 0) {
        dfs(x, visited, revAdj);
        count++;
      }
    }

    return count;
  }

  void toposort(int u, int visited[], Stack<Integer> stk, ArrayList<ArrayList<Integer>> adj) {

    visited[u] = 1;

    for (int v : adj.get(u)) {
      if (visited[v] == 0) {
        toposort(v, visited, stk, adj);
      }
    }

    stk.push(u);
  }

  void dfs(int u, int visited[], ArrayList<ArrayList<Integer>> adj) {

    visited[u] = 1;

    for (int v : adj.get(u)) {
      if (visited[v] == 0) {
        dfs(v, visited, adj);
      }
    }

  }
}

import java.util.ArrayList;
import java.util.Stack;

public class Graph_TopologicalSort {
  /*
   * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
   * vertices such that for every directed edge u-v, vertex u comes before v in
   * the ordering.
   */
  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

    boolean visited[] = new boolean[V];

    int ans[] = new int[V];
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        solve(adj, i, visited, stk);
      }
    }

    int k = 0;
    while (!stk.isEmpty()) {
      ans[k] = stk.pop();
      k++;
    }

    return ans;
  }

  static void solve(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[], Stack<Integer> stk) {

    visited[u] = true;

    for (Integer v : adj.get(u)) {
      if (visited[v] == false) {
        solve(adj, v, visited, stk);
      }
    }

    stk.push(u);
  }
}

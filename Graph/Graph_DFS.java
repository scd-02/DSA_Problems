import java.util.ArrayList;
import java.util.Stack;

public class Graph_DFS {
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

    boolean visited[] = new boolean[V];

    Stack<Integer> stk = new Stack<>();

    ArrayList<Integer> list = new ArrayList<>();

    dfsStk(adj, visited, stk, list);

    return list;

  }

  public static void dfsStk(ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> stk,
      ArrayList<Integer> list) {

    stk.push(0);
    visited[0] = true;
    list.add(0);

    while (!stk.isEmpty()) {

      int u = stk.pop();

      if (!visited[u]) {
        list.add(u);
        visited[u] = true;
      }

      ArrayList<Integer> e = adj.get(u);
      for (int v = e.size() - 1; v >= 0; v--) {

        if (visited[e.get(v)] == false) {
          stk.push(e.get(v));
        }
      }

    }
  }

}

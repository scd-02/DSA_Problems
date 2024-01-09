import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS {
  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

    ArrayList<Integer> ans = new ArrayList<>();

    Queue<Integer> q = new LinkedList<>();
    q.add(0);

    boolean visited[] = new boolean[V];
    visited[0] = true;

    while (!q.isEmpty()) {

      int u = q.poll();

      ans.add(u);

      for (int v : adj.get(u)) {

        if (visited[v] == false) {
          visited[v] = true;
          q.add(v);
        }

      }

    }
    return ans;
  }
}

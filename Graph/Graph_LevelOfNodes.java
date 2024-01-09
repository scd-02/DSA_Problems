import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_LevelOfNodes {
  int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {

    boolean visited[] = new boolean[V];
    Queue<Integer> q = new LinkedList<>();

    q.add(0);
    visited[0] = true;

    int level = -1;

    while (!q.isEmpty()) {

      level++;
      int size = q.size();

      for (int i = 0; i < size; i++) {
        // System.out.println(q);
        int u = q.poll();
        if (u == X)
          return level;

        for (Integer v : adj.get(u)) {
          if (!visited[v]) {
            q.add(v);
            visited[v] = true;
          }
        }

      }
    }

    return -1;
  }
}

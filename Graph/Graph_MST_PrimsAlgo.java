import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph_MST_PrimsAlgo {
  static class Tuple {
    int v;
    int w;

    Tuple(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  static int spanningTree(int V, int E, int edges[][]) {

    // creating adjacency list
    ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      adj.get(u).add(new Tuple(v, w));
      adj.get(v).add(new Tuple(u, w));
    }

    // Prism's algorithm
    int visited[] = new int[V];

    PriorityQueue<Tuple> q = new PriorityQueue<>((a, b) -> a.w - b.w);
    q.add(new Tuple(0, 0));

    int sum = 0;
    while (!q.isEmpty()) {

      Tuple p = q.poll();
      int u = p.v;
      int wt = p.w;

      if (visited[u] == 1)
        continue;

      visited[u] = 1;
      sum += wt;

      for (Tuple t : adj.get(u)) {
        int v = t.v;
        int ew = t.w;

        if (visited[v] == 0) {
          q.add(new Tuple(v, ew));
        }
      }

    }

    return sum;
  }
}

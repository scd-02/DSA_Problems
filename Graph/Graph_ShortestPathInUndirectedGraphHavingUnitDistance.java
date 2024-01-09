import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_ShortestPathInUndirectedGraphHavingUnitDistance {
  public int[] shortestPath(int[][] edges, int n, int m, int src) {

    // creating adjacency list
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      adj.get(edges[i][0]).add(edges[i][1]);
      adj.get(edges[i][1]).add(edges[i][0]);
    }

    // weight array
    int weight[] = new int[n];
    Arrays.fill(weight, Integer.MAX_VALUE);

    weight[src] = 0;

    // BFS
    Queue<Integer> q = new LinkedList<>();
    q.add(src);

    while (!q.isEmpty()) {

      int u = q.poll();

      for (int v : adj.get(u)) {
        if (weight[u] + 1 < weight[v]) {
          q.add(v);
          weight[v] = weight[u] + 1;
        }
      }

    }

    for (int i = 0; i < n; i++) {
      if (weight[i] == Integer.MAX_VALUE)
        weight[i] = -1;
    }

    return weight;
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_ShortestPathInWeightedUndirectedGraph {
  public List<Integer> shortestPath(int n, int m, int edges[][]) {

    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    // creating adjacency list
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
      adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
    }

    // dijkstra algorithm

    int parent[] = new int[n + 1];
    int weight[] = new int[n + 1];
    Arrays.fill(weight, Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    pq.add(new int[] { 1, 0 });
    parent[1] = 1;
    weight[1] = 0;

    while (!pq.isEmpty()) {

      int vertex[] = pq.poll();
      int u = vertex[0];
      int wt = vertex[1];

      for (Pair p : adj.get(u)) {
        int v = p.v;
        int edgeWt = p.w;

        if (wt + edgeWt < weight[v]) {
          weight[v] = wt + edgeWt;
          parent[v] = u;
          pq.add(new int[] { v, weight[v] });
        }
      }

    }

    // obtaining the result
    List<Integer> ans = new ArrayList<>();

    if (weight[n] == Integer.MAX_VALUE) {
      ans.add(-1);
      return ans;
    }

    ans.add(weight[n]);

    int vertex = n;
    while (parent[vertex] != vertex) {
      ans.add(vertex);
      vertex = parent[vertex];
    }
    ans.add(vertex);

    return ans;
  }

  class Pair {
    int v;
    int w;

    Pair(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
}

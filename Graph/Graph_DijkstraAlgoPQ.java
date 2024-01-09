import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph_DijkstraAlgoPQ {
  static int[] dijkstraPQ(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

    int weight[] = new int[V];
    Arrays.fill(weight, Integer.MAX_VALUE);
    weight[S] = 0;

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.w - b.w);
    q.add(new Pair(S, 0));

    while (!q.isEmpty()) {

      Pair p = q.poll();
      int u = p.u;
      int w = p.w;

      for (ArrayList<Integer> arr : adj.get(u)) {
        int v = arr.get(0);
        int edgeWeight = arr.get(1);

        if (w + edgeWeight < weight[v]) {
          weight[v] = w + edgeWeight;
          q.add(new Pair(v, weight[v]));
        }
      }

    }

    return weight;
  }

  static class Pair {
    int u;
    int w;

    Pair(int u, int w) {
      this.u = u;
      this.w = w;
    }
  }
}

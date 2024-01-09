import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_NoOfWaysToArriveAtDestination {
  static class Pair {
    int v;
    long time;

    Pair(int v, long time) {
      this.v = v;
      this.time = time;
    }
  }

  static int countPaths(int n, List<List<Integer>> roads) {
    int mod = 1000_000_000 + 7;
    // creating adjacency list
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < roads.size(); i++) {
      adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
      adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
    }

    // ways array to count the number of ways
    int ways[] = new int[n];
    ways[0] = 1;

    // djikstra algo
    long cost[] = new long[n];
    Arrays.fill(cost, Long.MAX_VALUE);
    cost[0] = 0;

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
    q.add(new Pair(0, 0));

    while (!q.isEmpty()) {

      Pair node = q.poll();
      int u = node.v;
      long w = node.time;

      for (Pair p : adj.get(u)) {
        int v = p.v;
        long ew = p.time;

        if (w + ew < cost[v]) {
          cost[v] = w + ew;
          q.add(new Pair(v, cost[v]));
          ways[v] = ways[u] % mod;
        } else if (w + ew == cost[v]) {
          ways[v] = (ways[u] % mod + ways[v] % mod) % mod;
        }
      }
    }

    return ways[n - 1];
  }
}

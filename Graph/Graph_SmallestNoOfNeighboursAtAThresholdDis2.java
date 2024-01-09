import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph_SmallestNoOfNeighboursAtAThresholdDis2 {
  class Pair {
    int v;
    int w;

    Pair(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  int findCity(int n, int m, int[][] edges, int distanceThreshold) {

    // adjacency list creation
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      adj.get(u).add(new Pair(v, w));
      adj.get(v).add(new Pair(u, w));
    }

    int minCity = Integer.MAX_VALUE;
    int city = -1;

    // shortest path from every node to every other node
    for (int i = 0; i < n; i++) {
      int dis[] = new int[n];
      Arrays.fill(dis, (int) 1e9);

      djikstra(adj, n, i, dis);

      // for counting cities that reach from i node with atmost threshold distance
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (dis[j] <= distanceThreshold) {
          count++;
        }
      }

      if (count <= minCity) {
        minCity = count;
        city = i;
      }
    }

    return city;
  }

  void djikstra(ArrayList<ArrayList<Pair>> adj, int n, int s, int dis[]) {
    dis[s] = 0;

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.w - b.w);
    q.add(new Pair(s, 0));

    while (!q.isEmpty()) {
      Pair node = q.poll();
      int u = node.v;
      int wt = node.w;

      for (Pair p : adj.get(u)) {
        int v = p.v;
        int ew = p.w;

        if (wt + ew < dis[v]) {
          dis[v] = wt + ew;
          q.add(new Pair(v, dis[v]));
        }
      }
    }

  }
}

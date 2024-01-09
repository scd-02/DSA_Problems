import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph_NetworkDelayTime {
  class Pair {
    int v;
    int time;

    Pair(int v, int time) {
      this.v = v;
      this.time = time;
    }
  }

  public int networkDelayTime(int[][] times, int n, int k) {

    // creating adjacency list
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < times.length; i++) {
      adj.get(times[i][0] - 1).add(new Pair(times[i][1] - 1, times[i][2]));
    }

    // applying djikstra
    int dis[] = new int[n];
    Arrays.fill(dis, Integer.MAX_VALUE);
    dis[k - 1] = 0;

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.time - b.time);
    q.add(new Pair(k - 1, 0));

    while (!q.isEmpty()) {

      Pair p = q.poll();
      int u = p.v;
      int t = p.time;

      for (Pair node : adj.get(u)) {
        int v = node.v;
        int ew = node.time;

        if (t + ew < dis[v]) {
          dis[v] = t + ew;
          q.add(new Pair(v, dis[v]));
        }
      }

    }

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if (dis[i] == Integer.MAX_VALUE)
        return -1;

      max = Math.max(max, dis[i]);
    }

    return max;
  }
}

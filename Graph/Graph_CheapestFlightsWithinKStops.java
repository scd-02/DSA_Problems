import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_CheapestFlightsWithinKStops {
  class Pair {
    int cost;
    int v;

    Pair(int v, int cost) {
      this.v = v;
      this.cost = cost;
    }
  }

  class Tuple {
    int stops;
    int cost;
    int u;

    Tuple(int stops, int u, int cost) {
      this.stops = stops;
      this.cost = cost;
      this.u = u;
    }
  }

  public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {

    // creating adjacency graph
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < flights.length; i++) {
      adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
    }

    // modified djikstra
    int cost[] = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);
    cost[src] = 0;

    Queue<Tuple> q = new LinkedList<>();
    q.add(new Tuple(0, src, 0));

    while (!q.isEmpty()) {
      Tuple t = q.poll();
      int u = t.u;
      int stops = t.stops;
      int totalPrice = t.cost;

      if (stops > k)
        continue;

      for (Pair p : adj.get(u)) {
        int v = p.v;
        int price = p.cost;

        if (totalPrice + price < cost[v] && stops <= k) {
          cost[v] = totalPrice + price;
          q.add(new Tuple(stops + 1, v, cost[v]));
        }
      }
    }

    if (cost[dst] == Integer.MAX_VALUE)
      return -1;

    return cost[dst];
  }
}

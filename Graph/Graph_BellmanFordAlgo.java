import java.util.ArrayList;
import java.util.Arrays;

public class Graph_BellmanFordAlgo {
  static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

    int dis[] = new int[V];
    Arrays.fill(dis, (int) 1e8);
    dis[S] = 0;

    // relaxing the edges for V - 1 times
    for (int i = 0; i < V - 1; i++) {

      for (ArrayList<Integer> e : edges) {
        int u = e.get(0);
        int v = e.get(1);
        int wt = e.get(2);

        if (dis[u] != (int) 1e8 && dis[u] + wt < dis[v]) {
          dis[v] = dis[u] + wt;
        }
      }

    }

    // to check for negative cycle we try to relax all the edges one more time
    for (ArrayList<Integer> e : edges) {
      int u = e.get(0);
      int v = e.get(1);
      int wt = e.get(2);

      if (dis[u] != (int) 1e8 && dis[u] + wt < dis[v]) {
        int temp[] = { -1 };
        return temp;
      }
    }

    return dis;
  }
}

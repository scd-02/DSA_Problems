import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_DijkstraAlgoQueue {
  /*
   * Given a weighted, undirected and connected graph of V vertices and an
   * adjacency list adj where adj[i] is a list of lists containing two integers
   * where the first integer of each list j denotes there is edge between i and j
   * , second integers corresponds to the weight of that edge . You are given the
   * source vertex S and You to Find the shortest distance of all the vertex's
   * from the source vertex S. You have to return a list of integers denoting
   * shortest distance between each node and Source vertex S.
   * 
   * 
   * Note: The Graph doesn't contain any negative weight cycle.
   */

  static int[] dijkstraBFS(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

    int weight[] = new int[V];
    Arrays.fill(weight, Integer.MAX_VALUE);
    weight[S] = 0;

    Queue<Integer> q = new LinkedList<>();
    q.add(S);

    while (!q.isEmpty()) {
      int u = q.poll();

      for (ArrayList<Integer> arr : adj.get(u)) {
        int v = arr.get(0);
        int w = arr.get(1);

        if (weight[u] + w < weight[v]) {
          weight[v] = weight[u] + w;
          q.add(v);
        }
      }
    }

    return weight;
  }

}

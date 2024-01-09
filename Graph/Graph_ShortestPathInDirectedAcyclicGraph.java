import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Graph_ShortestPathInDirectedAcyclicGraph {
  class Pair {
    int v;
    int w;

    Pair(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  public int[] shortestPath(int N, int M, int[][] edges) {

    // adjaceny list
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<Pair>());
    }

    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      adj.get(u).add(new Pair(v, w));
    }

    // toposort
    int visited[] = new int[N];
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < N; i++) {
      if (visited[i] == 0) {
        topoSort(i, visited, stk, adj);
      }
    }

    // shortest path
    int weight[] = new int[N];

    Arrays.fill(weight, Integer.MAX_VALUE);
    weight[0] = 0;

    while (!stk.isEmpty()) {
      int u = stk.pop();

      if (weight[u] != Integer.MAX_VALUE) {
        for (Pair p : adj.get(u)) {
          int v = p.v;
          int w = p.w;

          if (weight[u] + w < weight[v]) {
            weight[v] = weight[u] + w;
          }
        }
      }
    }

    // mark all the unreachable nodes as -1
    for (int i = 0; i < N; i++) {
      if (weight[i] == Integer.MAX_VALUE) {
        weight[i] = -1;
      }
    }

    return weight;
  }

  public void topoSort(int u, int visited[], Stack<Integer> stk, ArrayList<ArrayList<Pair>> adj) {

    visited[u] = 1;

    for (Pair p : adj.get(u)) {
      int v = p.v;
      if (visited[v] == 0) {
        topoSort(v, visited, stk, adj);
      }
    }

    stk.push(u);
  }
}

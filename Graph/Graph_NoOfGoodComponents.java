import java.util.ArrayList;

public class Graph_NoOfGoodComponents {
  public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {

    // creating adj graph
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int i = edge[0] - 1;
      int j = edge[1] - 1;

      adj.get(i).add(j);
      adj.get(j).add(i);
    }

    boolean visited[] = new boolean[v];
    int compVertices[] = new int[1];
    int compEdges[] = new int[1];

    int goodComp = 0;

    // traversing the graph in dfs manner
    for (int i = 0; i < v; i++) {

      if (visited[i] == false) {
        compVertices[0] = 1;
        compEdges[0] = 0;

        dfs(adj, i, visited, compVertices, compEdges);

        int formula = (compVertices[0] * (compVertices[0] - 1)) / 2;
        if (formula == (compEdges[0] / 2)) {
          goodComp++;
        }
      }

    }

    return goodComp;
  }

  public static void dfs(ArrayList<ArrayList<Integer>> adj, int u,
      boolean visited[], int vertices[], int edges[]) {

    visited[u] = true;
    edges[0] += adj.get(u).size();

    for (int v : adj.get(u)) {
      if (visited[v] == false) {
        vertices[0]++;
        dfs(adj, v, visited, vertices, edges);
      }
    }
  }
}

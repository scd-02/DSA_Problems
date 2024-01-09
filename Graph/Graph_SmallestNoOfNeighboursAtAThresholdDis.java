public class Graph_SmallestNoOfNeighboursAtAThresholdDis {
  int findCity(int n, int m, int[][] edges, int distanceThreshold) {

    // adjacency matrix creation
    int adj[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        adj[i][j] = (int) 1e9;
        if (i == j) {
          adj[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      adj[u][v] = w;
      adj[v][u] = w;
    }

    // shortest path from every node to every other node
    floydWarshall(adj, n);

    int minCity = Integer.MAX_VALUE;
    int city = -1;

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (adj[i][j] <= distanceThreshold) {
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

  void floydWarshall(int adj[][], int n) {

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
        }
      }
    }

  }
}

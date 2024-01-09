import java.util.ArrayList;

public class Graph_TransitiveClosureOfAGraph {
  
  // pure dfs traversal
  static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      ans.add(new ArrayList<>());

      for (int j = 0; j < N; j++) {
        ans.get(i).add(0);
      }

    }

    int adj[][] = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {

        if (graph[i][j] == 1 && i != j) {
          adj[i][j] = 1;
        }

      }
    }

    for (int i = 0; i < N; i++) {
      dfs(adj, N, i, i, ans);
    }

    return ans;
  }

  static void dfs(int adj[][], int n, int i, int j, ArrayList<ArrayList<Integer>> ans) {

    ans.get(i).set(j, 1);

    for (int neighbour = 0; neighbour < n; neighbour++) {
      if (adj[j][neighbour] == 1 && ans.get(i).get(neighbour) == 0) {
        dfs(adj, n, i, neighbour, ans);
      }
    }
  }
}

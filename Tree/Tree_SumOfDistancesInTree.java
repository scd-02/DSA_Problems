import java.util.ArrayList;

public class Tree_SumOfDistancesInTree {
  int dp[], size[], ans[];

  public int[] sumOfDistancesInTree(int n, int[][] edges) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    dp = new int[n];
    size = new int[n];
    ans = new int[n];

    // brute force
    // for(int i = 0; i < n; i++){
    // dfs(adj, i, -1);
    // ans[i] = dp[i];
    // }

    // rerooting
    dfs(adj, 0, -1);
    dfs_reroot(adj, 0, -1);

    return ans;
  }

  public void dfs(ArrayList<ArrayList<Integer>> adj, int u, int par) {

    size[u] = 1;
    dp[u] = 0;

    for (int v : adj.get(u)) {
      if (par != v) {
        dfs(adj, v, u);
        size[u] += size[v];
        dp[u] += dp[v] + size[v];
      }
    }

  }

  public void dfs_reroot(ArrayList<ArrayList<Integer>> adj, int u, int par) {

    ans[u] = dp[u];

    for (int v : adj.get(u)) {
      if (par != v) {
        reroot(u, v);
        dfs_reroot(adj, v, u);
        reroot(v, u);
      }
    }

  }

  public void reroot(int from, int to) {
    dp[from] -= dp[to] + size[to];
    size[from] -= size[to];

    dp[to] += dp[from] + size[from];
    size[to] += size[from];
  }
}

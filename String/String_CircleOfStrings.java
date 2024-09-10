import java.util.ArrayList;

public class String_CircleOfStrings {
  public int isCircle(String arr[]) {

    boolean mark[] = new boolean[26];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      adj.add(new ArrayList<>());
    }

    int indegree[] = new int[26];
    int outdegree[] = new int[26];

    for (String str : arr) {
      int u = str.charAt(0) - 'a';
      int v = str.charAt(str.length() - 1) - 'a';

      indegree[v]++;
      outdegree[u]++;

      adj.get(u).add(v);
      mark[u] = mark[v] = true;
    }

    for (int i = 0; i < 26; i++) {
      if (indegree[i] != outdegree[i])
        return 0;
    }

    return isConnected(arr[0].charAt(0) - 'a', adj, mark);
  }

  int isConnected(int src, ArrayList<ArrayList<Integer>> adj, boolean mark[]) {

    boolean visited[] = new boolean[26];
    dfs(src, adj, visited);

    for (int i = 0; i < 26; i++) {
      if (!visited[i] && mark[i])
        return 0;
    }

    return 1;
  }

  void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
    visited[u] = true;

    for (int v : adj.get(u)) {
      if (visited[v] == false) {
        dfs(v, adj, visited);
      }
    }
  }
}

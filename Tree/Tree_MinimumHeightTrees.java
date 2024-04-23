import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Tree_MinimumHeightTrees {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    List<Integer> ans = new ArrayList<>();
    if (n == 1) {
      ans.add(0);
      return ans;
    }

    // creating adj list
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    int degree[] = new int[n];

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      adj.get(u).add(v);
      adj.get(v).add(u);

      degree[u]++;
      degree[v]++;
    }

    // bfs
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (degree[i] == 1) {
        q.add(i);
      }
    }

    while (n > 2) {
      int size = q.size();
      n -= size;

      for (int i = 0; i < size; i++) {
        int u = q.poll();

        for (int v : adj.get(u)) {
          degree[v]--;
          if (degree[v] == 1)
            q.add(v);
        }
      }
    }

    while (!q.isEmpty()) {
      ans.add(q.poll());
    }

    return ans;
  }
}

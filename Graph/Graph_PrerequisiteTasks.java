import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_PrerequisiteTasks {
  public boolean isPossible(int N, int P, int[][] prerequisites) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < P; i++) {

      adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

    }

    int indegree[] = new int[N];
    for (int u = 0; u < N; u++) {
      for (int v : adj.get(u)) {
        indegree[v]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    ArrayList<Integer> topo = new ArrayList<>();
    while (!q.isEmpty()) {

      int u = q.poll();
      topo.add(u);

      for (int v : adj.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.add(v);
        }
      }

    }

    return topo.size() == N;
  }
}

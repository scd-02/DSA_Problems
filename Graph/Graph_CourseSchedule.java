import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_CourseSchedule {
  static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
    }

    int order[] = new int[n];
    int indegree[] = new int[n];

    for (int i = 0; i < n; i++) {
      for (int v : adj.get(i)) {
        indegree[v]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int count = 0;
    int i = 0;
    while (!q.isEmpty()) {

      int u = q.poll();
      count++;
      order[i++] = u;

      for (int v : adj.get(u)) {
        indegree[v]--;
        if (indegree[v] == 0) {
          q.add(v);
        }
      }
    }

    return count == n ? order : new int[0];
  }
}

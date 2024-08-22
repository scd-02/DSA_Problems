import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_AlienDictionary {
  public String findOrder(String[] dict, int N, int K) {

    // create the adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      adj.add(new ArrayList<>());
    }

    // compare two consecutive string where the first time two string differs
    for (int i = 0; i < N - 1; i++) {

      String s1 = dict[i];
      String s2 = dict[i + 1];

      int len = Math.min(s1.length(), s2.length());

      for (int j = 0; j < len; j++) {

        // add and edge from s1.char to s2.char as s1.char will come first
        if (s1.charAt(j) != s2.charAt(j)) {
          adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
          break;
        }

      }

    }

    ArrayList<Integer> topo = new ArrayList<>();
    HashSet<Integer> hs = new HashSet<>();
    topoSort(K, adj, topo);

    String order = "";
    for (int e : topo) {
      order += (char) (e + (int) 'a');
    }

    // some edge cases where the order is not complete
    if (order.length() < K) {
      for (int i = 0; i < K; i++) {
        if (!hs.contains(i)) {
          order += (char) (i + (int) 'a');
        }
      }
    }

    return order;
  }

  public void topoSort(int V, List<List<Integer>> adj, ArrayList<Integer> topo) {

    int indegree[] = new int[V];

    for (int i = 0; i < V; i++) {
      for (int v : adj.get(i)) {
        indegree[v]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

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
  }
}

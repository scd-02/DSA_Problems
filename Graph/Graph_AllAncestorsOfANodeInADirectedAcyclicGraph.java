import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;

public class Graph_AllAncestorsOfANodeInADirectedAcyclicGraph {

  class SolutionDFS {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

      // creating adj list
      List<List<Integer>> adj = new ArrayList<>();
      List<List<Integer>> ancestors = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
        ancestors.add(new ArrayList<>());
      }

      for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
      }

      for (int i = 0; i < n; i++) {
        ancestorDfs(adj, i, i, ancestors, new boolean[n]);
      }

      return ancestors;
    }

    void ancestorDfs(List<List<Integer>> adj, int u, int ancestor,
        List<List<Integer>> ancestors,
        boolean visited[]) {

      visited[u] = true;
      for (int v : adj.get(u)) {

        if (!visited[v]) {
          ancestors.get(v).add(ancestor);
          ancestorDfs(adj, v, ancestor, ancestors, visited);
        }
      }

    }
  }

  class SolutionBFS {
    int indegree[];

    public List<List<Integer>> getAncestors(int n, int[][] edges) {

      indegree = new int[n];

      // creating adjacency matrix
      List<List<Integer>> adj = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
      }

      for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        indegree[edge[1]]++;
      }

      List<Integer> topologicalOrder = topologicalSort(n, adj);

      List<List<Integer>> ancestorsList = new ArrayList<>();
      List<Set<Integer>> ancestorsSetList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        ancestorsList.add(new ArrayList<>());
        ancestorsSetList.add(new HashSet<>());
      }

      for (int node : topologicalOrder) {
        for (int neighbor : adj.get(node)) {
          // Add immediate parent, and other ancestors.
          ancestorsSetList.get(neighbor).add(node);
          ancestorsSetList
              .get(neighbor)
              .addAll(ancestorsSetList.get(node));
        }
      }

      // Convert sets to lists and sort them
      for (int i = 0; i < ancestorsList.size(); i++) {
        ancestorsList.get(i).addAll(ancestorsSetList.get(i));
        Collections.sort(ancestorsList.get(i));
      }

      return ancestorsList;
    }

    public List<Integer> topologicalSort(int n, List<List<Integer>> adj) {

      List<Integer> topologicalOrder = new ArrayList<>();
      Queue<Integer> q = new LinkedList<>();

      for (int i = 0; i < n; i++) {
        if (indegree[i] == 0)
          q.add(i);
      }

      while (!q.isEmpty()) {

        int u = q.poll();
        topologicalOrder.add(u);

        for (int v : adj.get(u)) {
          indegree[v]--;

          if (indegree[v] == 0) {
            q.add(v);
          }
        }

      }

      return topologicalOrder;
    }
  }
}

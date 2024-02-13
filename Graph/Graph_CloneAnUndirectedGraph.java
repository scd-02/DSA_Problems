import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_CloneAnUndirectedGraph {
  class Node {
    int val;
    ArrayList<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int val) {
      this.val = val;
      neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
      this.val = val;
      this.neighbors = neighbors;
    }
  }

  HashMap<Node, Node> map = new HashMap<>();

  Node cloneGraph(Node node) {

    if (node == null) {
      return null;
    }

    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node clone = new Node(node.val);
    map.put(node, clone);

    for (Node neigh : node.neighbors) {
      clone.neighbors.add(cloneGraph(neigh));
    }

    return clone;

  }

  class Pair {
    Node curr;
    Node ans;

    Pair(Node curr, Node ans) {
      this.curr = curr;
      this.ans = ans;
    }
  }

  Node cloneGraphBFS(Node node) {

    HashSet<Integer> visited = new HashSet<>();
    Node res = new Node(node.val);

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(node, res));

    visited.add(node.val);

    while (!q.isEmpty()) {

      Pair p = q.poll();

      Node curr = p.curr;
      Node ans = p.ans;

      ArrayList<Node> temp = new ArrayList<>();

      for (Node neigh : curr.neighbors) {

        Node v = new Node(neigh.val);
        temp.add(v);

        if (visited.contains(v.val) == false) {
          visited.add(v.val);
          q.add(new Pair(neigh, v));
        }

      }

      ans.neighbors = temp;
    }

    return res;

  }

  void dfs(Node curr, Node ans, HashSet<Integer> visited) {

    visited.add(curr.val);

    ArrayList<Node> temp = new ArrayList<>();
    for (Node neigh : curr.neighbors) {

      Node v = new Node(neigh.val);
      temp.add(v);

      if (!visited.contains(v.val)) {
        dfs(neigh, v, visited);
      }
    }

    ans.neighbors = temp;
  }
}

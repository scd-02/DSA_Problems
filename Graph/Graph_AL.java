import java.util.LinkedList;

public class Graph_AL {

  int size;
  LinkedList<LinkedList<Edge>> adj;

  static class Edge {
    int cost;
    int dest;

    Edge(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }
  }

  Graph_AL(int v) {
    this.size = v;
    adj = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      adj.add(new LinkedList<>());
    }
  }

  void addDirectedEdge(int src, int dest, int cost) {
    Edge e = new Edge(dest, cost);
    adj.get(src).add(e);
  }

  void addDirectedEdge(int src, int dest) {
    addDirectedEdge(src, dest, 1);
  }

  void addUndirectedEdge(int src, int dest, int cost) {
    addDirectedEdge(src, dest, cost);
    addDirectedEdge(dest, src, cost);
  }

  void addUndirectedEdge(int src, int dest) {
    addUndirectedEdge(src, dest, 1);
  }

  void display() {
    for (int i = 0; i < size; i++) {
      LinkedList<Edge> adjEdges = adj.get(i);

      System.out.print("\nVertex " + i + " is connectd to : ");
      for (Edge e : adjEdges) {
        System.out.print("(" + e.dest + " " + e.cost + ")");
      }
    }
  }

  public static void main() {
    Graph_AL gph = new Graph_AL(5);
    gph.addDirectedEdge(0, 1, 3);
    gph.addDirectedEdge(0, 4, 2);
    gph.addDirectedEdge(1, 2, 1);
    gph.addDirectedEdge(2, 3, 1);
    gph.addDirectedEdge(4, 1, -2);
    gph.addDirectedEdge(4, 3, 1);
    gph.display();
  }
}

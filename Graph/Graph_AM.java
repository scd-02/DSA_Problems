public class Graph_AM {

  int[][] adj;
  int size;

  Graph_AM(int size) {
    this.size = size;
    adj = new int[size][size];
  }

  public void addDirectedEdge(int src, int des, int cost) {
    adj[src][des] = cost;
  }

  public void addUndirectedEdge(int src, int des, int cost) {
    addDirectedEdge(src, des, cost);
    addDirectedEdge(des, src, cost);
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.print(i + " -> ");

      for (int j = 0; j < size; j++) {
        if (adj[i][j] != 0)
          System.out.print(j + " ");
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    Graph_AM graph = new Graph_AM(4);
    graph.addUndirectedEdge(0, 1, 1);
    graph.addUndirectedEdge(0, 2, 1);
    graph.addUndirectedEdge(1, 2, 1);
    graph.addUndirectedEdge(2, 3, 1);
    graph.display();
  }
}

import java.util.ArrayList;

public class Graph_SumOfDependenciesInAGraph {
  int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {

    int sum = 0;

    for (int i = 0; i < V; i++) {

      sum += adj.get(i).size();

    }

    return sum;
  }
}

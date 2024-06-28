import java.util.Arrays;

public class Graph_MaximumTotalImportanceOfRoads {
  public long maximumImportance(int n, int[][] roads) {

    long indegree[] = new long[n];

    for (int edge[] : roads) {
      indegree[edge[0]]++;
      indegree[edge[1]]++;
    }

    Arrays.sort(indegree);

    long value = 1;
    long importance = 0;
    for (int i = 0; i < n; i++) {
      importance += value * indegree[i];
      value++;
    }

    return importance;
  }
}

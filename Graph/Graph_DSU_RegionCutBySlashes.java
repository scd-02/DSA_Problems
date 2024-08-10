import java.util.Arrays;

public class Graph_DSU_RegionCutBySlashes {

  public int regionsBySlashes(String[] grid) {

    int size = grid.length;
    int verticesPerSide = size + 1;
    int totalVertices = verticesPerSide * verticesPerSide;

    int[] parent = new int[totalVertices];
    Arrays.fill(parent, -1);
    for (int i = 0; i < verticesPerSide; i++) {
      for (int j = 0; j < verticesPerSide; j++) {
        if (i == 0 ||
            j == 0 ||
            i == verticesPerSide - 1 ||
            j == verticesPerSide - 1) {
          int point = i * verticesPerSide + j;
          parent[point] = 0;
        }
      }
    }
    System.out.println(Arrays.toString(parent));
    parent[0] = -1;
    int regionCount = 1;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {

        if (grid[i].charAt(j) == '/') {
          int topRight = i * verticesPerSide + (j + 1);
          int bottomLeft = (i + 1) * verticesPerSide + j;

          regionCount += union(parent, topRight, bottomLeft);
        } else if (grid[i].charAt(j) == '\\') {
          int topLeft = i * verticesPerSide + j;
          int bottomRight = (i + 1) * verticesPerSide + (j + 1);

          regionCount += union(parent, topLeft, bottomRight);
        }
      }
    }

    return regionCount;
  }

  int find(int[] parent, int x) {
    if (parent[x] == -1)
      return x;

    return parent[x] = find(parent, parent[x]);
  }

  int union(int parent[], int u, int v) {

    int parent1 = find(parent, u);
    int parent2 = find(parent, v);

    if (parent1 == parent2)
      return 1;

    parent[parent2] = parent1;

    return 0;
  }
}
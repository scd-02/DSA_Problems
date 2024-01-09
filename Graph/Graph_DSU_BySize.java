public class Graph_DSU_BySize {

  int parent[];
  int size[];

  Graph_DSU_BySize(int v) {
    parent = new int[v];
    size = new int[v];

    for (int i = 0; i < v; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  int find(int x) {

    if (parent[x] == x) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  void unionBySize(int x, int y) {
    int up_x = find(x);
    int up_y = find(y);

    if (up_x == up_y)
      return;

    if (size[up_x] < size[up_y]) {
      parent[up_x] = up_y;
      size[up_y] += size[up_x];
    } else {
      parent[up_y] = up_x;
      size[up_x] += size[up_y];
    }

  }
}

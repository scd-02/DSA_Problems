public class Graph_DSU_ByRank {

  int parent[];
  int rank[];

  Graph_DSU_ByRank(int v) {
    parent = new int[v];
    rank = new int[v];

    for (int i = 0; i < v; i++) {
      parent[i] = i;
    }
  }

  int find(int x) {

    if (parent[x] == x) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  void unionByRank(int x, int y) {
    int up_x = find(x);
    int up_y = find(y);

    if (up_x == up_y)
      return;

    if (rank[up_x] < rank[up_y]) {
      parent[up_x] = up_y;
    } else if (rank[up_x] > rank[up_y]) {
      parent[up_y] = up_x;
    } else {
      parent[up_y] = up_x;
      rank[up_x] += 1;
    }
  }
}

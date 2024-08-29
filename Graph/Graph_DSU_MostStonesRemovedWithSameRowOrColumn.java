import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Graph_DSU_MostStonesRemovedWithSameRowOrColumn {
  private class UnionFind {

    int parent[];
    int components;
    Set<Integer> unique;

    UnionFind(int n) {
      parent = new int[n];
      Arrays.fill(parent, -1);

      components = 0;
      unique = new HashSet<>();
    }

    int find(int x) {

      if (!unique.contains(x)) {
        unique.add(x);
        components++;
      }

      if (parent[x] == -1)
        return x;

      return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
      int root_a = find(a);
      int root_b = find(b);

      if (root_a == root_b)
        return;

      components--;
      parent[root_b] = root_a;
    }
  }

  public int removeStones(int[][] stones) {
    int n = stones.length;

    UnionFind uf = new UnionFind(20002);

    for (int i = 0; i < n; i++) {
      uf.union(stones[i][0], stones[i][1] + 10001);
    }

    return n - uf.components;
  }
}

public class Graph_UnionFind {

  // function to find parent of a node
  public int find(int x, int par[]) {
    if (par[x] != x) {
      par[x] = find(par[x], par);
    }

    return par[x];
  }

  // function to merge two nodes
  public void union_(int a, int b, int par[], int rank[]) {

    int root_a = find(a, par);
    int root_b = find(b, par);

    if (root_a == root_b)
      return;

    if (rank[root_a] < rank[root_b]) {
      par[root_a] = root_b;
    } else if (rank[root_a] > rank[root_b]) {
      par[root_b] = root_a;
    } else {
      par[root_b] = root_a;
      rank[root_a] = rank[root_a] + 1;
    }

  }

  // Function to check whether 2 nodes are connected or not.
  public Boolean isConnected(int a, int b, int par[], int rank[]) {
    return find(a, par) == find(b, par);
  }
}

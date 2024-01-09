import java.util.ArrayList;

public class Tree_KSumPaths {
  int count = 0;
  int mod = 1_000_000_000 + 7;

  public int sumK(Node root, int k) {
    ArrayList<Integer> path = new ArrayList<>();

    preorder(root, k, path);

    return count;
  }

  public void preorder(Node root, int k, ArrayList<Integer> path) {

    if (root == null)
      return;

    path.add(root.data);

    int sum = 0;
    for (int i = path.size() - 1; i >= 0; i--) {
      sum += path.get(i);
      if (sum == k) {
        count = (count + 1) % mod;
      }
    }

    preorder(root.left, k, path);
    preorder(root.right, k, path);

    path.remove(path.size() - 1);
  }
}

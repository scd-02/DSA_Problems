import java.util.ArrayList;

public class BackTracking_RatInAMazeProblem1 {
  int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
  String[] dirStr = { "U", "D", "L", "R" };

  public ArrayList<String> findPath(int[][] mat) {
    ArrayList<String> ans = new ArrayList<>();

    findAllPaths(mat, mat.length, 0, 0, new StringBuilder(), ans);

    return ans;
  }

  void findAllPaths(
      int[][] mat, int n, int i, int j,
      StringBuilder temp, ArrayList<String> ans) {
    if (i < 0 || i >= n || j < 0 || j >= n || mat[i][j] == 0)
      return;

    if (i == n - 1 && j == n - 1) {
      ans.add(temp.toString());
      return;
    }

    for (int k = 0; k < 4; k++) {
      int x = dir[k][0];
      int y = dir[k][1];

      temp.append(dirStr[k]);
      mat[i][j] = 0;

      findAllPaths(mat, n, i + x, j + y, temp, ans);

      mat[i][j] = 1;
      temp.deleteCharAt(temp.length() - 1);
    }
  }

}

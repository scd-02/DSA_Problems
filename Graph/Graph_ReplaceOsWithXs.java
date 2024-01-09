public class Graph_ReplaceOsWithXs {

  static char[][] fill(int n, int m, char a[][]) {
    char ans[][] = new char[n][m];

    // traverse all 4 boundary
    for (int i = 0; i < n; i++) {

      // top to bottom - left
      int j = 0;
      if (a[i][j] == 'O') {
        dfs(a, i, j, n, m, ans);
      }

      // top to bottom - right
      j = m - 1;
      if (a[i][j] == 'O') {
        dfs(a, i, j, n, m, ans);
      }
    }

    for (int j = 0; j < m; j++) {

      // left to right - top
      int i = 0;
      if (a[i][j] == 'O') {
        dfs(a, i, j, n, m, ans);
      }

      // left to right - bottom
      i = n - 1;
      if (a[i][j] == 'O') {
        dfs(a, i, j, n, m, ans);
      }
    }

    convert(ans, n, m);
    return ans;
  }

  static void dfs(char a[][], int i, int j, int n, int m, char[][] ans) {

    if (i < 0 || i >= n || j < 0 || j >= m)
      return;

    if (a[i][j] == 'X' || ans[i][j] == 'B')
      return;

    ans[i][j] = 'B';

    dfs(a, i + 1, j, n, m, ans);
    dfs(a, i - 1, j, n, m, ans);
    dfs(a, i, j + 1, n, m, ans);
    dfs(a, i, j - 1, n, m, ans);

  }

  static void convert(char ans[][], int n, int m) {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (ans[i][j] == 'B') {
          ans[i][j] = 'O';
        } else {
          ans[i][j] = 'X';
        }
      }
    }

  }
}

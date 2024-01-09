import java.util.ArrayList;

public class Matrix_FindWordInAGrid {
  public int[][] searchWord(char[][] grid, String word) {
    int n = grid.length;
    int m = grid[0].length;

    ArrayList<int[]> list = new ArrayList<>();

    int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {

        if (grid[row][col] == word.charAt(0)) {

          for (int i = 0; i < 8; i++) {

            int dr = row;
            int dc = col;
            int k;

            for (k = 1; k < word.length(); k++) {

              dr = dr + x[i];
              dc = dc + y[i];

              if (dr >= n || dr < 0 || dc >= m || dc < 0)
                break;

              if (word.charAt(k) != grid[dr][dc])
                break;

            }

            if (k == word.length()) {
              list.add(new int[] { row, col });
              break;
            }

          }

        }

      }
    }

    int ans[][] = new int[list.size()][2];

    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }

    return ans;
  }
}

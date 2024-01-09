import java.util.ArrayList;
import java.util.List;

public class Matrix_LetterCollection {
  static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][]) {
    int hop1x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int hop1y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

    int hop2x[] = { -2, -2, -2, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 2, 2, 2 };
    int hop2y[] = { -2, -1, 0, 1, 2, -2, 2, -2, 2, -2, 2, -2, -1, 0, 1, 2 };

    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < q; i++) {

      if (queries[i][0] == 1) {

        int sum = 0;
        for (int dir = 0; dir < 8; dir++) {

          int x = queries[i][1] + hop1x[dir];
          int y = queries[i][2] + hop1y[dir];

          if (x < 0 || x >= n || y < 0 || y >= m) {
            continue;
          } else {
            sum += mat[x][y];
          }
        }

        ans.add(sum);
      } else {

        int sum = 0;
        for (int dir = 0; dir < 16; dir++) {

          int x = queries[i][1] + hop2x[dir];
          int y = queries[i][2] + hop2y[dir];

          if (x < 0 || x >= n || y < 0 || y >= m) {
            continue;
          } else {
            sum += mat[x][y];
          }

        }

        ans.add(sum);
      }
    }

    return ans;
  }
}

import java.util.ArrayList;

public class Matrix_SankePattern {
  static ArrayList<Integer> snakePattern(int matrix[][]) {
    ArrayList<Integer> ans = new ArrayList<>();
    int n = matrix.length;

    for (int row = 0; row < n; row++) {

      if (row % 2 != 0) {

        for (int col = n - 1; col >= 0; col--) {
          ans.add(matrix[row][col]);
        }

      } else {

        for (int col = 0; col < n; col++) {
          ans.add(matrix[row][col]);
        }

      }

    }

    return ans;
  }
}

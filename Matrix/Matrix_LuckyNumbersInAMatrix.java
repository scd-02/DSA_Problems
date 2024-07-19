import java.util.ArrayList;
import java.util.List;

public class Matrix_LuckyNumbersInAMatrix {
  public List<Integer> luckyNumbers(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {
      int minInd = 0;
      int min = Integer.MAX_VALUE;

      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] < min) {
          min = matrix[i][j];
          minInd = j;
        }
      }

      int max = min;
      boolean flag = true;

      for (int k = 0; k < matrix.length; k++) {
        if (k != i && matrix[k][minInd] > max) {
          flag = false;
          break;
        }
      }

      if (flag) {
        ans.add(min);
      }
    }

    return ans;
  }
}

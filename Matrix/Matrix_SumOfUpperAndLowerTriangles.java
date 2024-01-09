import java.util.ArrayList;

public class Matrix_SumOfUpperAndLowerTriangles {
  static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
    ArrayList<Integer> ans = new ArrayList<>();

    int upper = 0, lower = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {

        upper += matrix[i][j];
        lower += matrix[j][i];
      }
    }

    ans.add(upper);
    ans.add(lower);

    return ans;
  }
}

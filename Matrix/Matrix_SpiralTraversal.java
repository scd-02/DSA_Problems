import java.util.ArrayList;

public class Matrix_SpiralTraversal {
  static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {

    ArrayList<Integer> ans = new ArrayList<>();

    int rs = 0, cs = 0;
    int re = r - 1, ce = c - 1;

    int totalIter = r * c;

    int countIter = 0;

    while (countIter < totalIter) {

      for (int i = cs; countIter < totalIter && i <= ce; i++) {
        ans.add(matrix[rs][i]);
        countIter++;
      }
      rs++;

      for (int i = rs; countIter < totalIter && i <= re; i++) {
        ans.add(matrix[i][ce]);
        countIter++;
      }
      ce--;

      for (int i = ce; countIter < totalIter && i >= cs; i--) {
        ans.add(matrix[re][i]);
        countIter++;
      }
      re--;

      for (int i = re; countIter < totalIter && i >= rs; i--) {
        ans.add(matrix[i][cs]);
        countIter++;
      }
      cs++;
    }

    return ans;
  }
}

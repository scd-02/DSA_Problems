import java.util.ArrayList;
import java.util.HashMap;

public class Dp_LargestRectangularSubMatrixWhoseSumIs0 {
  public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {

    int n = a.length;
    int m = a[0].length;

    int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
    int maxArea = Integer.MIN_VALUE;

    for (int ci = 0; ci < m; ci++) {

      // temp array for storing sum of rows from ri to rj
      int temp[] = new int[n];

      for (int cj = ci; cj < m; cj++) {

        for (int r = 0; r < n; r++) {
          temp[r] = temp[r] + a[r][cj];
        }

        // computing max length of sub array with 0 sum
        int rows[] = { 0 };
        int rowe[] = { 0 };

        int len = maxlenSubArrWith0sum(temp, rows, rowe);

        int area = len * (cj - ci + 1);

        if (len > 0 && area > maxArea) {
          maxArea = area;
          r1 = rows[0];
          r2 = rowe[0];
          c1 = ci;
          c2 = cj;
        }
      }

    }

    // storing the sub matrix
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    if (maxArea == Integer.MIN_VALUE)
      return ans;

    for (int i = r1; i <= r2; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = c1; j <= c2; j++) {
        temp.add(a[i][j]);
      }
      ans.add(temp);
    }

    return ans;
  }

  static int maxlenSubArrWith0sum(int[] arr, int s[], int e[]) {

    int maxLen = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {

      sum += arr[i];

      if (sum == 0) {
        maxLen = i + 1;
        s[0] = 0;
        e[0] = i;
      }

      if (map.containsKey(sum)) {

        if (maxLen < i - map.get(sum)) {

          s[0] = map.get(sum) + 1;
          e[0] = i;
          maxLen = i - map.get(sum);

        }

      } else {
        map.put(sum, i);
      }
    }

    return maxLen;
  }
}

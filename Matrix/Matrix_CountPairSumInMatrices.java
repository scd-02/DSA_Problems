public class Matrix_CountPairSumInMatrices {
  int countPairs(int mat1[][], int mat2[][], int n, int x) {

    int r1 = 0, r2 = n - 1;
    int c1 = 0, c2 = n - 1;

    int ans = 0;

    while (r1 < n && r2 >= 0) {

      int val = mat1[r1][c1] + mat2[r2][c2];
      // System.out.println(r1 + " " +c1 + " " + r2 + " " + c2);
      if (val == x) {
        ans++;
        c1++;
        c2--;
      } else if (val < x) {
        c1++;
      } else {
        c2--;
      }

      if (c1 >= n) {
        r1++;
        c1 = 0;
      }

      if (c2 < 0) {
        r2--;
        c2 = n - 1;
      }
    }

    return ans;
  }

}

public class Matrix_SearchInASortedMatrix {
  public static int matSearch(int mat[][], int n, int m, int x) {

    for (int row = 0; row < n; row++) {

      if (x >= mat[row][0] && x <= mat[row][m - 1]) {

        for (int col = 0; col < m; col++) {
          if (mat[row][col] == x) {
            return 1;
          }
        }
      }
    }

    return 0;
  }

  public static int matSearchBS(int mat[][], int n, int m, int x) {

    int row = 0;
    int col = m - 1;

    while (row < n && col >= 0) {

      if (mat[row][col] == x)
        return 1;
      else if (mat[row][col] < x)
        row++;
      else
        col--;
    }

    return 0;
  }
}

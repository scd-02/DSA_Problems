public class Matrix_LetsPlay {
  static int isSuperSimilar(int n, int m, int mat[][], int x) {

    for (int i = 0; i < n; i++) {

      int temp[] = new int[m];

      for (int j = 0; j < m; j++) {
        temp[j] = mat[i][j];
      }

      if (i % 2 == 0) {

        rotate(temp, m, m - (x % m));

      } else {

        rotate(temp, m, x % m);

      }

      for (int k = 0; k < m; k++) {
        if (mat[i][k] != temp[k])
          return 0;
      }
    }

    return 1;
  }

  static void rotate(int arr[], int n, int k) {

    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
    reverse(arr, 0, n - 1);

  }

  static void reverse(int arr[], int s, int e) {

    while (s <= e) {
      int temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }

  }
}

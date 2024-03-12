public class Maths_GeneralisedFibonacciNo {
  static long genFibNum(Long a, Long b, Long c, long n, long m) {

    if (n <= 2)
      return 1 % m;

    /*
     * we need eq a*f(n - 1) + b * f(n - 2) + c
     * resultant matrix will be [f(n) f(n - 1) 1] which is 3 X 1
     * so to reprsent it eq in matix we need
     * mat = {[a b c] [1 0 0] [0 0 1]} and
     * res = {[1 0 0] [0 1 0] [0 0 1]}
     * we are using res 3 * 3 to make our calculation easy
     * the way it should be done is
     * res [f(n - 1) f(n - 2) 1]
     */
    long mat[][] = {
        { a, b, c },
        { 1, 0, 0 },
        { 0, 0, 1 }
    };

    return pow(mat, n - 2, m);
  }

  static long pow(long mat[][], long n, long m) {

    long res[][] = {
        { 1, 0, 0 },
        { 0, 1, 0 },
        { 0, 0, 1 }
    };

    while (n > 0) {
      if ((n & 1) == 1) {
        res = multiply(res, mat, m);
      }
      mat = multiply(mat, mat, m);
      n >>= 1;
    }

    return (res[0][0] + res[0][1] + res[0][2]) % m;
  }

  static long[][] multiply(long[][] mat1, long[][] mat2, long m) {

    long ans[][] = new long[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {

        for (int k = 0; k < 3; k++) {
          ans[i][j] = (ans[i][j] + mat1[i][k] * mat2[k][j]) % m;
        }

      }
    }

    return ans;
  }

  static void display(long mat[][]) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat.length; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}

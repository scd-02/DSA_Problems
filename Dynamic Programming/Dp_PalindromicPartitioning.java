public class Dp_PalindromicPartitioning {

  // T(n) = O(n^2) s(n) = O(n^2)
  static int palindromicPartitionOptimized(String s) {
    int n = s.length();
    boolean[][] p = new boolean[n][n];

    findPalindrome(p, s);

    int cut[] = new int[n];
    cut[0] = 0;

    for (int j = 1; j < n; j++) {

      if (p[0][j]) {
        cut[j] = 0;
      } else {
        int min = Integer.MAX_VALUE;

        for (int i = j; i >= 1; i--) {
          if (p[i][j]) {
            min = Math.min(min, cut[i - 1]);
          }
        }

        cut[j] = min + 1;
      }

    }

    return cut[n - 1];
  }

  // T(n) = O(n^3) s(n) = O(n^2)
  static int palindromicPartition(String s) {
    int n = s.length();
    int cut[][] = new int[n][n];
    boolean[][] p = new boolean[n][n];

    findPalindrome(p, s);

    for (int g = 0; g < n; g++) {
      for (int i = 0, j = g; j < n; i++, j++) {

        if (g == 0) {
          cut[i][j] = 0;
        } else if (g == 1) {
          if (s.charAt(i) == s.charAt(j)) {
            cut[i][j] = 0;
          } else {
            cut[i][j] = 1;
          }
        } else {
          if (p[i][j]) {
            cut[i][j] = 0;
          } else {
            int min = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
              int left = cut[i][k];
              int right = cut[k + 1][j];

              min = Math.min(min, (left + right + 1));
            }

            cut[i][j] = min;
          }
        }
      }
    }

    return cut[0][n - 1];
  }

  static void findPalindrome(boolean[][] p, String s) {

    for (int g = 0; g < s.length(); g++) {
      for (int i = 0, j = g; j < s.length(); i++, j++) {

        if (g == 0) {
          p[i][j] = true;
        } else if (g == 1) {
          p[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          if (s.charAt(i) == s.charAt(j) && p[i + 1][j - 1]) {
            p[i][j] = true;
          } else {
            p[i][j] = false;
          }
        }
      }
    }

  }
}

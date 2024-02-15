public class Graph_CountAllPossiblePath {
  public int isPossible(int[][] paths) {
    int n = paths.length;

    for (int i = 0; i < n; i++) {
      int degree = 0;

      for (int j = 0; j < n; j++) {
        if (paths[i][j] == 1) {
          degree++;
        }
      }

      if (degree % 2 != 0) {
        return 0;
      }

    }

    return 1;
  }
}

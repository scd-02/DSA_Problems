public class BackTracking_WordSearch {
  public boolean exist(char[][] board, String word) {
    int n = board.length;
    int m = board[0].length;

    boolean visited[][] = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == word.charAt(0)) {
          boolean res = findWord(i, j, n, m, board, 0, word, visited);
          if (res)
            return true;
        }
      }
    }
    return false;
  }

  public boolean findWord(int i, int j, int n, int m, char board[][], int index,
      String word, boolean visited[][]) {

    if (index == word.length())
      return true;
      
    if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(index))
      return false;

    visited[i][j] = true;

    boolean left = findWord(i, j - 1, n, m, board, index + 1, word, visited);
    boolean right = findWord(i, j + 1, n, m, board, index + 1, word, visited);
    boolean up = findWord(i - 1, j, n, m, board, index + 1, word, visited);
    boolean down = findWord(i + 1, j, n, m, board, index + 1, word, visited);

    if (left || right || up || down)
      return true;

    visited[i][j] = false;
    return false;
  }
}

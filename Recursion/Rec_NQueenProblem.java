import java.util.ArrayList;

public class Rec_NQueenProblem {
  static ArrayList<ArrayList<Integer>> nQueen(int n) {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    int board[][] = new int[n + 1][n + 1];

    nQueenSolve(1, n, board, new ArrayList<>(), ans);

    return ans;

  }

  static boolean isSafe(int row, int col, int board[][], int n) {

    int dupRow = row;
    int dupCol = col;

    // upper diagonal (left)
    while (row >= 1 && col >= 1) {
      if (board[row][col] == 1)
        return false;

      row--;
      col--;
    }

    // left
    row = dupRow;
    col = dupCol;

    while (col >= 1) {
      if (board[row][col] == 1)
        return false;

      col--;
    }

    // lower diagonal(left)
    col = dupCol;

    while (row <= n && col >= 1) {
      if (board[row][col] == 1)
        return false;

      row++;
      col--;
    }

    return true;
  }

  static void nQueenSolve(int col, int n, int board[][], ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {

    if (col > n) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    for (int row = 1; row <= n; row++) {

      if (isSafe(row, col, board, n)) {

        board[row][col] = 1;
        temp.add(row);

        nQueenSolve(col + 1, n, board, temp, ans);

        board[row][col] = 0;
        temp.remove(temp.size() - 1);

      }

    }
  }
}

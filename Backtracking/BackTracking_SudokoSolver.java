public class BackTracking_SudokoSolver {
  static boolean SolveSudoku(int grid[][]) {

    int n = grid.length;

    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {

        // cell is empty
        if (grid[row][col] == 0) {
          
          //fill the cell with 1 to 9
          for (int i = 1; i <= 9; i++) {
            
            //isSafe == all unique numbers in col, row, 3*3 block
            if (isSafe(row, col, i, grid)) {
              grid[row][col] = i;

              boolean isSudokuPossible = SolveSudoku(grid);

              if (isSudokuPossible)
                return true;
              else
                grid[row][col] = 0;
            }
          }

          //after applying all values from 1 to 9 if no soln is possible
          return false;
        }
      }
    }

    return true;
  }

  static boolean isSafe(int row, int col, int val, int grid[][]) {

    for (int i = 0; i < grid.length; i++) {

      if (grid[row][i] == val)
        return false;

      if (grid[i][col] == val)
        return false;

      if (grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
        return false;

    }

    return true;
  }
}
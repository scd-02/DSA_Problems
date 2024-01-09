import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph_MakingALargeIsland {

  // storing the names of islands
  static HashMap<Integer, Integer> map = new HashMap<>();

  static int dfs(int i, int j, int[][] grid, boolean[][] visited, int name, int n) {
    // checking if index is invalid to return 0
    if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || visited[i][j])
      return 0;
    visited[i][j] = true;
    // giving name to the cell in the grid
    grid[i][j] = name;
    // finding the 1's connected to the current cell
    int count = 1 + dfs(i + 1, j, grid, visited, name, n) + dfs(i, j + 1, grid, visited, name, n) +
        dfs(i - 1, j, grid, visited, name, n) + dfs(i, j - 1, grid, visited, name, n);
    return count;
  }

  public int largestIsland2(int n, int[][] grid) {
    // starting from 2 as 1 is already an element in the matrix
    int name = 2;
    boolean[][] visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // checking if cell is 1 and is not already visited
        if (grid[i][j] == 1 && !visited[i][j]) {
          int count = dfs(i, j, grid, visited, name, n);
          map.put(name, count);
          name++;
        }
      }
    }
    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          // fetching the name of the island adjacent to the current cell
          int down = (i + 1 < n) ? grid[i + 1][j] : 0;
          int up = (i - 1 >= 0) ? grid[i - 1][j] : 0;
          int left = (j + 1 < n) ? grid[i][j + 1] : 0;
          int right = (j - 1 >= 0) ? grid[i][j - 1] : 0;
          // set is used to store different islands connected to current cell
          Set<Integer> set = new HashSet<>();
          // storing names of adjacent islands
          set.add(down);
          set.add(up);
          set.add(right);
          set.add(left);
          // result is initialized from 1 as the island count increases by 1 if a 0 is
          // changed to 1
          int result = 1;
          for (int val : set) {
            result += map.getOrDefault(val, 0);
          }
          answer = Math.max(answer, result);
        }
      }
    }
    // when all the cells were already 1
    if (answer == 0)
      return n * n;
    return answer;
  }

  // Time limit exceeded
  // public int largestIsland(int N, int[][] grid) {

  //   int largest = -1;

  //   boolean visited[][];

  //   for (int i = 0; i < N; i++) {
  //     for (int j = 0; j < N; j++) {

  //       int currLarg = 0;
  //       visited = new boolean[N][N];

  //       if (grid[i][j] == 1) {
  //         currLarg = dfs(grid, N, i, j, visited);
  //       } else {
  //         grid[i][j] = 1;
  //         currLarg = dfs(grid, N, i, j, visited);
  //         grid[i][j] = 0;
  //       }

  //       largest = Math.max(currLarg, largest);

  //     }
  //   }

  //   return largest;
  // }

  // int dfs(int grid[][], int n, int cr, int cc, boolean visited[][]) {

  //   if (cr >= n || cr < 0 || cc >= n || cc < 0)
  //     return 0;

  //   if (grid[cr][cc] == 0 || visited[cr][cc] == true)
  //     return 0;

  //   visited[cr][cc] = true;

  //   int left = dfs(grid, n, cr - 1, cc, visited);
  //   int right = dfs(grid, n, cr + 1, cc, visited);
  //   int bottom = dfs(grid, n, cr, cc - 1, visited);
  //   int top = dfs(grid, n, cr, cc + 1, visited);

  //   return 1 + left + right + bottom + top;
  // }
}

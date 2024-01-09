import java.util.LinkedList;
import java.util.Queue;

public class Matrix_RottenOranges {
  public int orangesRotting(int[][] grid) {

    Queue<int[]> q = new LinkedList<>();

    int n = grid.length;
    int m = grid[0].length;

    int freshOranges = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (grid[i][j] == 2)
          q.add(new int[] { i, j, 0 });
        else if (grid[i][j] == 1)
          freshOranges++;

      }
    }

    int direction[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    while (!q.isEmpty()) {

      int[] rn = q.poll();

      int cx = rn[0];
      int cy = rn[1];
      int time = rn[2];

      for (int i = 0; i < 4; i++) {
        int nx = cx + direction[i][0];
        int ny = cy + direction[i][1];

        if (nx < n && nx >= 0 && ny < m && ny >= 0 && grid[nx][ny] == 1) {

          grid[nx][ny] = 2;
          q.add(new int[] { nx, ny, time + 1 });
          freshOranges--;

          if (freshOranges == 0)
            return time + 1;
        }
      }

    }

    return freshOranges == 0 ? 0 : -1;
  }

}

// Time Limit exceeded

// class RotNode{
// int time;
// int x, y;

// RotNode(int x, int y, int time){
// this.time = time;
// this.x = x;
// this.y = y;
// }
// }

// public int orangesRotting(int[][] grid)
// {

// Queue<RotNode> q = new LinkedList<>();

// int n = grid.length;
// int m = grid[0].length;

// int [][]storage = new int [n][m];

// for(int i = 0; i < n; i++){
// for(int j = 0; j < m; j++){
// storage[i][j] = Integer.MAX_VALUE;

// if(grid[i][j] == 2){
// q.add(new RotNode(i, j, 0));
// }

// }
// }

// while(!q.isEmpty()){
// RotNode rn = q.poll();

// int x = rn.x;
// int y = rn.y;

// bfs(grid, storage, q, x - 1, y, n, m, rn.time);
// bfs(grid, storage, q, x + 1, y, n, m, rn.time);
// bfs(grid, storage, q, x, y - 1, n, m, rn.time);
// bfs(grid, storage, q, x, y + 1, n, m, rn.time);

// }

// int ans = 0;

// for(int i = 0; i < n; i++){
// for(int j = 0; j < m; j++){

// if(grid[i][j] == 1){
// if(storage[i][j] == Integer.MAX_VALUE) return -1;

// ans = Math.max(ans, grid[i][j]);
// }

// }
// }

// return ans;

// }

// void bfs(int [][]grid, int storage[][], Queue<RotNode> q, int x, int y, int
// n, int m, int time){

// if(x >= n || x < 0 || y >= m || y < 0) return;

// if(grid[x][y] == 1){
// q.add(new RotNode(x, y, time + 1));
// storage[x][y] = time + 1;
// }

// }

// public int orangesRotting(int[][] grid)
// {

// int n = grid.length;
// int m = grid[0].length;

// int [][]storage = new int [n][m];

// for(int i = 0; i < n; i++){
// for(int j = 0; j < m; j++){
// storage[i][j] = Integer.MAX_VALUE;
// }
// }

// for(int i = 0; i < n; i++){
// for(int j = 0; j < m; j++){

// if(grid[i][j] == 2){
// rot(grid, storage, i, j, n, m, 0);
// }

// }
// }

// int ans = 0;

// for(int i = 0; i < n; i++){
// for(int j = 0; j < m; j++){

// if(grid[i][j] == 1){
// if(storage[i][j] == Integer.MAX_VALUE) return -1;

// ans = Math.max(ans, grid[i][j]);
// }

// }
// }

// return ans;

// }











// public static void rot(int grid[][], int storage[][], int cr, int cc, int n,
// int m, int time){

// if(cr >= n || cr < 0 || cc >= m || cc < 0) return;

// if(grid[cr][cc] == 0 || storage[cr][cc] <= time) return;

// storage[cr][cc] = time;

// rot(grid, storage, cr+1, cc, n, m, time+1);
// rot(grid, storage, cr-1, cc, n, m, time+1);
// rot(grid, storage, cr, cc+1, n, m, time+1);
// rot(grid, storage, cr, cc-1, n, m, time+1);

// }

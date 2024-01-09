public class Graph_FloodFill {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int sourceColor = image[sr][sc];
    int n = image.length;
    int m = image[0].length;

    solve(image, n, m, sr, sc, newColor, sourceColor);

    return image;
  }

  public void solve(int[][] image, int n, int m, int currRow, int currCol, int newColor, int sourceColor) {

    if (currRow >= n || currRow < 0 || currCol >= m || currCol < 0)
      return;

    if (image[currRow][currCol] != sourceColor || image[currRow][currCol] == newColor)
      return;

    image[currRow][currCol] = newColor;

    solve(image, n, m, currRow + 1, currCol, newColor, sourceColor);
    solve(image, n, m, currRow - 1, currCol, newColor, sourceColor);
    solve(image, n, m, currRow, currCol + 1, newColor, sourceColor);
    solve(image, n, m, currRow, currCol - 1, newColor, sourceColor);

  }
}

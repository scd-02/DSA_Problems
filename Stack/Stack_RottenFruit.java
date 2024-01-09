public class Stack_RottenFruit {
  public static int rottenFruit(int a[][], int maxRow, int maxCol) {
    int traversed[][] = new int[maxRow][maxCol];

    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        traversed[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        if (a[i][j] == 2) {
          rotFruitNeigh(a, maxRow, maxCol, i, j, traversed, 0);
        }
      }
    }
    int maxDay = 0;
    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        if (a[i][j] == 1) {
          if (traversed[i][j] == Integer.MAX_VALUE)
            return -1;
          maxDay = Math.max(maxDay, traversed[i][j]);
        }
      }
    }

    return maxDay;
  }

  public static void rotFruitNeigh(int a[][], int maxRow, int maxCol, int currRow, int currCol, int traversed[][],
      int day) {

    if (currRow < 0 || currRow >= maxRow || currCol < 0 || currCol >= maxCol)
      return;

    if (traversed[currRow][currCol] <= day || a[currRow][currCol] == 0)
      return;

    traversed[currRow][currCol] = day;

    rotFruitNeigh(a, maxRow, maxCol, currRow - 1, currCol, traversed, day + 1);
    rotFruitNeigh(a, maxRow, maxCol, currRow + 1, currCol, traversed, day + 1);
    rotFruitNeigh(a, maxRow, maxCol, currRow, currCol - 1, traversed, day + 1);
    rotFruitNeigh(a, maxRow, maxCol, currRow, currCol + 1, traversed, day + 1);
  }

  public static void main(String[] args) {
    int arr[][] = {
        { 0, 0, 0, 0, 0 },
        { 2, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 2 },
        { 0, 0, 0, 0, 1 },
        { 1, 2, 0, 0, 1 }
    };
    System.out.println(rottenFruit(arr, 5, 5));
  }
}

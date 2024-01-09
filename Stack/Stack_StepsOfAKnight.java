public class Stack_StepsOfAKnight {
  public static int stepsOfKnight(int size, int srcX, int srcY, int disX, int disY) {

    int traversed[][] = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        traversed[i][j] = Integer.MAX_VALUE;
      }
    }

    stepsToNeigh(size, srcX - 1, srcY - 1, traversed, 0);
    return traversed[disX - 1][disY - 1];
  }

  public static void stepsToNeigh(int size, int currRow, int currCol, int traversed[][], int dis) {
    if (currRow < 0 || currRow >= size || currCol < 0 || currCol >= size)
      return;
    if (traversed[currRow][currCol] <= dis)
      return;
    traversed[currRow][currCol] = dis;

    stepsToNeigh(size, currRow - 2, currCol + 1, traversed, dis + 1);
    stepsToNeigh(size, currRow - 2, currCol - 1, traversed, dis + 1);
    stepsToNeigh(size, currRow + 2, currCol + 1, traversed, dis + 1);
    stepsToNeigh(size, currRow + 2, currCol - 1, traversed, dis + 1);
    stepsToNeigh(size, currRow - 1, currCol - 2, traversed, dis + 1);
    stepsToNeigh(size, currRow + 1, currCol - 2, traversed, dis + 1);
    stepsToNeigh(size, currRow - 1, currCol + 2, traversed, dis + 1);
    stepsToNeigh(size, currRow + 1, currCol + 2, traversed, dis + 1);
  }

  public static void main(String[] args) {
    System.out.println(stepsOfKnight(8, 7, 8, 1, 1));
  }
}

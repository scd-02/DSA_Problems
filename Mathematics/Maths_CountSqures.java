public class Maths_CountSqures {
  static int countSquares(int N) {

    int count = (int) Math.sqrt(N);

    return (count * count == N) ? count - 1 : count;
  }
}

public class Tree_ShortestDistanceInAnInfiniteTree {
  static int distance(int X, int Y) {

    if (X == Y)
      return 0;

    int ans = (X > Y) ? distance(X >> 1, Y) : distance(X, Y >> 1);

    return 1 + ans;

  }
}

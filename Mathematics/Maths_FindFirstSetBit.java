public class Maths_FindFirstSetBit {
  public static int getFirstSetBit(int n) {

    int position = 0;

    while (n != 0) {

      if ((n & 1) == 1) {
        position++;
        break;
      }

      position++;
      n = n >> 1;
    }

    return position;
  }

  public static int getFirstSetBit2(int n) {

    if (n == 0)
      return 0;

    n = n & ~(n - 1);
    int index = (int) (Math.log(n) / Math.log(2));

    return index + 1;

  }
}

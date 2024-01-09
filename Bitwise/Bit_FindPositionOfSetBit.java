public class Bit_FindPositionOfSetBit {
  static int findPosition(int N) {
    if (N == 0)
      return -1;

    int position = 0;
    int count = 0;
    int index = 0;

    while (N > 0) {

      if ((N & 1) == 1) {
        index = position;
      }

      count += N & 1;
      N = N >> 1;
      position++;
    }

    return count > 1 ? -1 : index + 1;
  }
}

public class Bit_MinimumBitFlipsToConvertNumber {
  public int minBitFlips(int start, int goal) {

    int count = 0;

    while (start != 0 || goal != 0) {
      int bit_start = start & 1;
      int bit_goal = goal & 1;

      if (bit_start != bit_goal)
        count++;

      start >>= 1;
      goal >>= 1;
    }

    return count;
  }
}

package Pointers;

public class TwoPointer_SeparateBlackAndWhiteBalls {
  public long minimumSteps(String s) {

    long swaps = 0;
    int whitePos = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        swaps += i - whitePos;
        whitePos++;
      }
    }

    return swaps;
  }
}

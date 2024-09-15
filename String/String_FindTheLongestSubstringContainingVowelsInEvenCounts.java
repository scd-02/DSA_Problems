import java.util.Arrays;

public class String_FindTheLongestSubstringContainingVowelsInEvenCounts {
  public int findTheLongestSubstring(String s) {

    int charMap[] = new int[26];
    charMap['a' - 'a'] = 1;
    charMap['e' - 'a'] = 2;
    charMap['i' - 'a'] = 4;
    charMap['o' - 'a'] = 8;
    charMap['u' - 'a'] = 16;

    int longestSubstr = 0;
    int xorSum = 0;

    int[] prevOcc = new int[32];
    Arrays.fill(prevOcc, -1);

    for (int i = 0; i < s.length(); i++) {

      int ch = s.charAt(i) - 'a';

      xorSum ^= charMap[ch];
      if (prevOcc[xorSum] == -1 && xorSum != 0) {
        prevOcc[xorSum] = i;
      }

      longestSubstr = Math.max(longestSubstr, i - prevOcc[xorSum]);
    }

    return longestSubstr;
  }
}

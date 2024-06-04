import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class String_LongestPalindrome {
  public int longestPalindrome2(String s) {
    Set<Character> characterSet = new HashSet<>();
    int res = 0;

    // Loop over characters in the string
    for (char c : s.toCharArray()) {
      // If set contains the character, match found
      if (characterSet.contains(c)) {
        characterSet.remove(c);
        // add the two occurrences to our palindrome
        res += 2;
      } else {
        // add the character to the set
        characterSet.add(c);
      }
    }

    // if any character remains, we have at least one unmatched
    // character to make the center of an odd length palindrome.
    if (!characterSet.isEmpty())
      res++;

    return res;
  }

  public int longestPalindrome1(String s) {

    HashMap<Character, Integer> frequency = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }

    int count = 0;
    boolean oddFreq = false;

    for (int freq : frequency.values()) {
      if (freq % 2 == 0) {
        count += freq;
      } else {
        count += freq - 1;
        oddFreq = true;
      }
    }

    if (oddFreq) {
      count++;
    }

    return count;
  }
}

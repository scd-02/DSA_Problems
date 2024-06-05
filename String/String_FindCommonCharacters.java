import java.util.ArrayList;
import java.util.List;

public class String_FindCommonCharacters {
  public List<String> commonChars(String[] words) {

    int commonCharFreq[] = new int[26];
    List<String> ans = new ArrayList<>();

    countFreq(commonCharFreq, words[0]);

    for (String word : words) {

      int currCharFreq[] = new int[26];
      countFreq(currCharFreq, word);

      // intersection of strings
      for (int i = 0; i < 26; i++) {
        commonCharFreq[i] = Math.min(currCharFreq[i], commonCharFreq[i]);
      }

    }

    for (int i = 0; i < 26; i++) {
      for (int count = 0; count < commonCharFreq[i]; count++) {
        ans.add("" + (char) ('a' + i));
      }
    }

    return ans;
  }

  void countFreq(int freq[], String word) {
    for (int i = 0; i < word.length(); i++) {
      freq[word.charAt(i) - 'a']++;
    }
  }
}

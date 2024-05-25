import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BackTracking_WordBreak2 {
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> ans = new ArrayList<>();
    HashSet<String> hs = new HashSet<>();

    for (String str : wordDict) {
      hs.add(str);
    }

    rec(s, new StringBuilder(), 0, ans, hs);

    return ans;
  }

  public void rec(String s, StringBuilder output, int index, List<String> ans, HashSet<String> hs) {

    if (index == s.length()) {
      ans.add(output.toString().trim());
      return;
    }
    for (int end = index + 1; end <= s.length(); end++) {

      String word = s.substring(index, end);
      if (hs.contains(word)) {
        int currLen = output.length();

        output.append(word).append(" ");
        rec(s, output, end, ans, hs);

        // revert back to original output for more strings
        output.setLength(currLen);
      }
    }
  }
}

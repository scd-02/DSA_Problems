import java.util.ArrayList;
import java.util.List;

public class Rec_PalindromePartitioning {
  List<List<String>> result = new ArrayList<>();

  public List<List<String>> partition(String s) {
    rec(s, 0, new ArrayList<>());

    return result;
  }

  public void rec(String s, int index, List<String> currList) {
    if (index == s.length()) {
      result.add(new ArrayList<>(currList));
      return;
    }

    for (int i = index; i < s.length(); i++) {

      if (isPalindrome(s, index, i)) {
        String currStr = s.substring(index, i + 1);
        currList.add(currStr);
        rec(s, i + 1, currList);
        currList.remove(currList.size() - 1);
      }

    }

  }

  public boolean isPalindrome(String s, int start, int end) {

    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }
}

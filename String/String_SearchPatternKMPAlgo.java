import java.util.ArrayList;

public class String_SearchPatternKMPAlgo {
  ArrayList<Integer> search(String pat, String txt) {
    ArrayList<Integer> ans = new ArrayList<>();

    int patSize = pat.length();
    int txtSize = txt.length();

    int lps[] = new int[patSize];
    longestPrefix(pat, lps);

    int j = 0;
    int i = 0;

    while (i < txtSize) {

      if (txt.charAt(i) == pat.charAt(j)) {
        i++;
        j++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }

      if (j == patSize) {
        int pos = i - patSize;
        ans.add(pos + 1);

        j = lps[j - 1];
      }

    }

    return ans;
  }

  void longestPrefix(String s, int[] lps) {
    int n = s.length();

    for (int i = 1; i < n; i++) {

      int j = lps[i - 1];

      while (j > 0 && s.charAt(j) != s.charAt(i)) {
        j = lps[j - 1];
      }

      if (s.charAt(j) == s.charAt(i)) {
        j++;
      }

      lps[i] = j;

    }

  }
}

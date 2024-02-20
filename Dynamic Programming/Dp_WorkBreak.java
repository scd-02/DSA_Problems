import java.util.ArrayList;
import java.util.Arrays;

public class Dp_WorkBreak {
  public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
    // return rec(0, s, dictionary);

    int dp[] = new int[s.length()];
    Arrays.fill(dp, -1);

    return mem(0, s, dictionary, dp);

    // return tab(s, dictionary);
  }

  public static int rec(int i, String s, ArrayList<String> dict) {

    if (i == s.length()) {
      return 1;
    }

    for (int j = i + 1; j <= s.length(); j++) {
      String substr = s.substring(i, j);
      if (dict.contains(substr) && rec(j, s, dict) == 1) {
        return 1;
      }
    }

    return 0;
  }

  public static int mem(int i, String s, ArrayList<String> dict, int dp[]) {

    if (i == s.length()) {
      return 1;
    }

    if (dp[i] != -1)
      return dp[i];

    for (int j = i + 1; j <= s.length(); j++) {
      String substr = s.substring(i, j);
      if (dict.contains(substr) && mem(j, s, dict, dp) == 1) {
        return dp[i] = 1;
      }
    }

    return dp[i] = 0;
  }

  public static int tab(String s, ArrayList<String> dict) {

    int len = s.length();
    int dp[] = new int[len + 1];

    dp[len] = 1;

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i + 1; j <= len; j++) {
        String substr = s.substring(i, j);
        if (dict.contains(substr) && dp[j] == 1) {
          dp[i] = 1;
          break;
        }
      }

    }

    return dp[0];
  }
}

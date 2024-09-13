public class String_LongestPalindromicSubstring {
  public String longestPalindrome(String s) {

    if (s.length() <= 1)
      return s;

    String maxStr = s.substring(0, 1);

    for (int i = 1; i < s.length(); i++) {

      String odd = expandCenter(s, i, i);
      String even = expandCenter(s, i - 1, i);

      if (odd.length() > maxStr.length()) {
        maxStr = odd;
      }

      if (even.length() > maxStr.length()) {
        maxStr = even;
      }

    }

    return maxStr;
  }

  private String expandCenter(String s, int left, int right) {

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    return s.substring(left + 1, right);
  }
}

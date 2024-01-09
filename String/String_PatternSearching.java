public class String_PatternSearching {
  int search(String text, String pat) {

    if (text.equals(pat))
      return 1;

    String[] ans = text.split(pat, 0);

    return (ans.length != 0 && ans[0] != text) ? 1 : 0;
  }
}

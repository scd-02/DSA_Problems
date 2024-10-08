public class Stack_MinimumAddToMakeParenthesesValid {
  public int minAddToMakeValid(String s) {

    int close = 0, open = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == ')') {
        if (open > 0) {
          open--;
        } else {
          close++;
        }
      } else {
        open++;
      }
    }

    return open + close;
  }
}

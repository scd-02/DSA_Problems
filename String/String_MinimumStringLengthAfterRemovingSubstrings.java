import java.util.Stack;

public class String_MinimumStringLengthAfterRemovingSubstrings {
  public int minLength(String s) {

    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (!stk.isEmpty() && ((ch == 'B' && stk.peek() == 'A') || (ch == 'D' && stk.peek() == 'C'))) {
        stk.pop();
      } else {
        stk.push(ch);
      }
    }

    return stk.size();
  }
}

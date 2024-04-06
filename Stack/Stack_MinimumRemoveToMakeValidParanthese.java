import java.util.Stack;

public class Stack_MinimumRemoveToMakeValidParanthese {
  public String minRemoveToMakeValid(String s) {
    Stack<Character> stk = new Stack<>();

    int leftCount = 0, rightCount = 0;

    for (int i = 0; i < s.length(); i++) {

      char ch = s.charAt(i);
      if (ch == '(') {
        leftCount++;
      }

      if (ch == ')') {
        rightCount++;
      }

      if (rightCount > leftCount) {
        rightCount--;
        continue;
      } else {
        stk.push(ch);
      }

    }

    StringBuilder ans = new StringBuilder();

    while (!stk.isEmpty()) {
      char c = stk.pop();

      if (leftCount > rightCount && c == '(') {
        leftCount--;
        continue;
      } else {
        ans.append(c);
      }

    }

    return ans.reverse().toString();
  }
}

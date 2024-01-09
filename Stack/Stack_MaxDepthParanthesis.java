import java.util.Stack;

public class Stack_MaxDepthParanthesis {
  public static int maxDepth(String s) {
    int count = 0;
    int maxDepth = 0;
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stk.push(ch);
        count++;
      } else if (ch == ')') {
        stk.pop();
        count--;
      }
      if (count > maxDepth) {
        maxDepth = count;
      }
    }
    return maxDepth;
  }
}

import java.util.Stack;

public class Stack_BalancedParanthesis {
  public static boolean isBalancedParanthesis(String s) {
    Stack<Character> stk = new Stack<>();

    for (char ch : s.toCharArray()) {
      switch (ch) {
        case '{':
        case '[':
        case '(':
          stk.push(ch);
          break;
        case '}':
          if (stk.isEmpty() || stk.pop() != '{')
            return false;
          break;
        case ']':
          if (stk.isEmpty() || stk.pop() != '[')
            return false;
          break;
        case ')':
          if (stk.isEmpty() || stk.pop() != '(')
            return false;
          break;
      }
    }
    return stk.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isBalancedParanthesis("{ab(cde[sss])}"));
  }
}

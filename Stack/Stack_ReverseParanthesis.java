import java.util.Stack;

public class Stack_ReverseParanthesis {
  public static int reversePar(String s, int size) {
    Stack<Character> stk = new Stack<>();
    int openCount = 0;
    int closeCount = 0;

    if (size % 2 != 0) {
      return -1;
    }
    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stk.push(ch);
      } else if (ch == ')') {
        if (stk.size() != 0 && stk.peek() == '(') {
          stk.pop();
        } else {
          stk.push(ch);
        }
      }
    }
    while (!stk.isEmpty()) {
      if (stk.pop() == '(')
        openCount++;
      else
        closeCount++;
    }
    return (int) Math.ceil(closeCount / 2.0) + (int) Math.ceil(openCount / 2.0);
  }

  public static void main(String[] args) {
    String s = ")(())(((";
    System.out.println(reversePar(s, s.length()));
  }
}

import java.util.Stack;

public class Stack_LongestContinuousParenthesis {
  public static int longestCountBalPar(String s, int size) {
    Stack<Integer> stk = new Stack<>();
    int length = 0;

    stk.push(-1);
    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stk.push(i);
      } else {
        stk.pop();
        if (stk.size() != 0) {
          length = Math.max(length, i - stk.peek());
        } else {
          stk.push(i);
        }
      }
    }
    return length;
  }

  public static void main(String[] args) {
    String s = "())((()))(())()(()";
    String s1 = ")";
    System.out.println(longestCountBalPar(s, s.length()));
    System.out.println(longestCountBalPar(s1, s1.length()));
  }
}

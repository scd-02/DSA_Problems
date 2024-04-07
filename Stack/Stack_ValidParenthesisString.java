import java.util.Stack;

public class Stack_ValidParenthesisString {
  public boolean checkValidString(String s) {
    Stack<Integer> starInd = new Stack<>();
    Stack<Integer> stkInd = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        stkInd.push(i);
      } else if (ch == '*') {
        starInd.push(i);
      } else {

        if (stkInd.isEmpty() && starInd.isEmpty())
          return false;
        if (!stkInd.isEmpty()) {
          stkInd.pop();
        } else {
          starInd.pop();
        }
      }
    }

    while (!stkInd.isEmpty()) {
      if (starInd.isEmpty() || stkInd.peek() > starInd.peek())
        return false;
      stkInd.pop();
      starInd.pop();
    }

    return true;
  }
}

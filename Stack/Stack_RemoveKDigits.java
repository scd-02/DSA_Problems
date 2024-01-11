import java.util.Stack;

public class Stack_RemoveKDigits {
  public String removeKdigits(String S, int k) {

    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < S.length(); i++) {

      while (!stk.isEmpty() && stk.peek() > S.charAt(i) && k > 0) {
        stk.pop();
        k--;
      }

      stk.push(S.charAt(i));
    }

    while (k > 0) {
      stk.pop();
      k--;
    }

    if (stk.size() == 0) {
      return "0";
    }

    StringBuilder res = new StringBuilder("");

    while (!stk.isEmpty()) {
      res.append(stk.pop() + "");
    }

    res = res.reverse();

    int index = 0;
    while (index < res.length() - 1 && res.charAt(index) == '0') {
      index++;
    }

    return res.substring(index);
  }
}

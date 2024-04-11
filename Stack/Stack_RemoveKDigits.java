import java.util.Stack;

public class Stack_RemoveKDigits {
  public String removeKdigits(String num, int k) {

    Stack<Character> stk = new Stack<>();

    for (char digit : num.toCharArray()) {

      while (!stk.isEmpty() && k > 0 && stk.peek() > digit) {
        stk.pop();
        k--;
      }

      stk.push(digit);

    }

    // post processing if k > 0 then remove digits from top of the stack
    while (k > 0 && !stk.isEmpty()) {
      stk.pop();
      k--;
    }

    // resulting string
    StringBuilder ans = new StringBuilder();
    while (!stk.isEmpty()) {
      ans.append(stk.pop());
    }

    ans.reverse();

    // removing leading zeroes
    while (ans.length() > 0 && ans.charAt(0) == '0') {
      ans.deleteCharAt(0);
    }

    return ans.length() > 0 ? ans.toString() : "0";
  }
}

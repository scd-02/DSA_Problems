import java.util.Stack;

public class Stack_ReverseStackWithoutSpace {
  static void reverse(Stack<Integer> s) {
    if (s.size() == 0) {
      return;
    }

    int val = s.pop();
    reverse(s);
    insertBottom(s, val);
  }

  static void insertBottom(Stack<Integer> s, int val) {

    if (s.isEmpty()) {
      s.push(val);
      return;
    }

    int x = s.pop();
    insertBottom(s, val);
    s.push(x);

  }
}

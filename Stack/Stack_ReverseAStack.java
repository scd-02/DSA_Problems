import java.util.ArrayDeque;
import java.util.Stack;

public class Stack_ReverseAStack {
  public static void reverse(Stack<Integer> stk) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    while (!stk.isEmpty()) {
      q.add(stk.pop());
    }

    while (!q.isEmpty()) {
      stk.push(q.poll());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stk = new Stack<>();
    stk.push(1);
    stk.push(5);
    stk.push(8);
    stk.push(10);
    reverse(stk);
    System.out.println(stk);
  }
}

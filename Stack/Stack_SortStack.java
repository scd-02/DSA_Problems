import java.util.Stack;

public class Stack_SortStack {
  public static void sortStack(Stack<Integer> stk) {
    if (!stk.isEmpty()) {
      int temp = stk.pop();
      sortStack(stk);
      sortedIns(stk, temp);
    }
  }

  public static void sortedIns(Stack<Integer> stk, int x) {
    if (stk.isEmpty() || stk.peek() <= x) {
      stk.push(x);
      return;
    }

    int temp = stk.pop();
    sortedIns(stk, x);
    stk.push(temp);
  }

  public static void main(String[] args) {
    Stack<Integer> stk = new Stack<>();
    stk.push(11);
    stk.push(5);
    stk.push(3);
    stk.push(7);
    stk.push(4);
    sortStack(stk);
    System.out.println(stk);
  }
}

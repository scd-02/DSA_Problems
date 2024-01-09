import java.util.Stack;

public class Stack_StockAnalyst {
  public static void stockHikePoints(int a[]) {
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < a.length; i++) {
      while (!stk.isEmpty() && (a[stk.peek()] <= a[i])) {
        stk.pop();
      }
      if (stk.isEmpty() || a[stk.peek()] > a[i]) {
        stk.push(i);
      }
    }
    while (!stk.isEmpty()) {
      System.out.print(a[stk.pop()] + " ");
    }
  }

  public static void main(String[] args) {
    int a[] = { 66, 55, 54, 59, 65, 42, 45, 50, 39, 35, 40, 21, 10, 19, 20 };

    stockHikePoints(a);
  }
}

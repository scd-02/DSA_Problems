import java.util.Stack;

public class Stack_NextLargerEle {
  public static void nextLarger(int a[]) {
    Stack<Integer> stk = new Stack<>();

    int ans[] = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      while (!stk.isEmpty() && a[stk.peek()] < a[i]) {
        ans[stk.pop()] = a[i];
      }
      stk.push(i);
    }
    while (!stk.isEmpty()) {
      ans[stk.pop()] = -1;
    }

    for (int e : ans) {
      System.out.print(e + " ");
    }
  }

  public static void main(String[] args) {
    int a[] = { 6, 3, 4, 5, 1, 4, 13, 12, 10, 9, 11 };
    nextLarger(a);
  }
}

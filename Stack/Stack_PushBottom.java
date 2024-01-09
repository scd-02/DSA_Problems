import java.util.Stack;

public class Stack_PushBottom {
  public static void pushBottom(Stack<Integer> stk, int ele) {
    if (stk.isEmpty()) {
      stk.push(ele);
    } else {
      int temp = stk.pop();
      pushBottom(stk, ele);
      stk.push(temp);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stk = new Stack<>();
    stk.push(1);
    stk.push(5);
    stk.push(8);
    stk.push(10);
    pushBottom(stk, 3);
    System.out.println(stk);
  }
}

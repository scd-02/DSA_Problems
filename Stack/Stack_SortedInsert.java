import java.util.Stack;

public class Stack_SortedInsert {
  public static void sortedIns(Stack<Integer> stk, int ele) {
    if (stk.isEmpty() || stk.peek() <= ele)
      stk.push(ele);
    else {
      int temp = stk.pop();
      sortedIns(stk, ele);
      stk.push(temp);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stk = new Stack<>();
    stk.push(1);
    stk.push(5);
    stk.push(8);
    stk.push(10);
    sortedIns(stk, 3);
    System.out.println(stk);
  }
}
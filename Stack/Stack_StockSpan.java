import java.util.Arrays;
import java.util.Stack;

public class Stack_StockSpan {
  public static int[] stockSpanRange(int stockPrice[]) {

    int ans[] = new int[stockPrice.length];
    Stack<Integer> stk = new Stack<>();
    ans[0] = 1;
    stk.push(0);

    for (int i = 1; i < stockPrice.length; i++) {
      while (!stk.isEmpty() && stockPrice[i] >= stockPrice[stk.peek()]) {
        stk.pop();
      }
      ans[i] = (stk.isEmpty()) ? (i + 1) : (i - stk.peek());
      stk.push(i);
    }

    return ans;
  }

  public static void main(String[] args) {
    int sp[] = { 5, 3, 1, 2, 4, 7 };
    System.out.println(Arrays.toString(stockSpanRange(sp)));
  }
}

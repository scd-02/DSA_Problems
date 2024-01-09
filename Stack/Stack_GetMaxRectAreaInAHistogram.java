import java.util.Stack;

public class Stack_GetMaxRectAreaInAHistogram {
  public static int maxAreaInHistogram(int a[], int size) {
    Stack<Integer> stk = new Stack<>();

    int maxArea = 0;
    int top, topArea, i = 0;

    while (i < size) {
      while (i < size && (stk.isEmpty() || a[i] >= a[stk.peek()])) {
        stk.push(i);
        i++;
      }

      while (!stk.isEmpty() && (i == size || a[i] < a[stk.peek()])) {
        top = stk.peek();
        stk.pop();
        topArea = a[top] * (stk.isEmpty() ? (i - 1) : (i - stk.peek() - 1));
        if (maxArea < topArea)
          maxArea = topArea;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int sp[] = { 9, 10, 12, 6, 8, 7, 4, 40 };
    System.out.println(maxAreaInHistogram(sp, sp.length));
  }
}

import java.util.Stack;

public class Stack_MaximumRectangularAreaInAHistogram {
  public static long getMaxArea(long hist[], long n) {
    int len = (int) n;

    Stack<Integer> stk = new Stack<>();

    int leftSmaller[] = new int[len];
    int rightSmaller[] = new int[len];

    for (int i = 0; i < len; i++) {
      while (!stk.isEmpty() && hist[stk.peek()] >= hist[i]) {
        stk.pop();
      }

      if (stk.isEmpty())
        leftSmaller[i] = 0;
      else
        leftSmaller[i] = stk.peek() + 1;
      stk.push(i);
    }

    while (!stk.isEmpty())
      stk.pop();

    for (int i = len - 1; i >= 0; i--) {
      while (!stk.isEmpty() && hist[stk.peek()] >= hist[i]) {
        stk.pop();
      }
      if (stk.isEmpty())
        rightSmaller[i] = len - 1;
      else
        rightSmaller[i] = stk.peek() - 1;
      stk.push(i);
    }

    long maxArea = 0;
    for (int i = 0; i < len; i++) {
      maxArea = Math.max(maxArea, (rightSmaller[i] - leftSmaller[i] + 1) * hist[i]);
    }

    return maxArea;
  }

  public static long getMaxAreaOptimized(long hist[], long n) {
    int len = (int) n;

    Stack<Integer> stk = new Stack<>();
    long maxArea = 0;

    for (int i = 0; i <= len; i++) {

      while (!stk.isEmpty() && (i == len || hist[stk.peek()] >= hist[i])) {
        long height = hist[stk.peek()];
        stk.pop();

        int width = 0;
        if (stk.isEmpty())
          width = i;
        else
          width = i - stk.peek() - 1;

        maxArea = Math.max(maxArea, height * width);
      }
      stk.push(i);
    }

    return maxArea;
  }
}

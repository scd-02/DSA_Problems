public class Stack_DesignAStackWithIncrementOperation {
  private int stack[];
  private int increment[];
  private int top;

  public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.top = -1;
    }

  public void push(int x) {
    if (top < stack.length - 1) {
      stack[++top] = x;
    }
  }

  public int pop() {
    if (top < 0)
      return -1;

    int ele = stack[top] + increment[top];

    if (top > 0) {
      increment[top - 1] += increment[top];
    }

    increment[top] = 0;
    top--;
    return ele;
  }

  public void increment(int k, int val) {
    if (top >= 0) {
      int index = Math.min(top, k - 1);
      increment[index] += val;
    }
  }
}

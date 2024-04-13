import java.util.Stack;

public class Stack_MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {

    int row = matrix.length;
    int col = matrix[0].length;

    int histogram[] = new int[col];

    int maxSum = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '1') {
          histogram[j] += 1;
        } else {
          histogram[j] = 0;
        }
      }
      int maxAreaInHistogram = maximumRectangularArea(histogram);
      maxSum = Math.max(maxSum, maxAreaInHistogram);
    }

    return maxSum;
  }

  public int maximumRectangularArea(int histogram[]) {
    int n = histogram.length;

    Stack<Integer> stk = new Stack<>();

    int maxArea = 0;
    for (int i = 0; i <= n; i++) {
      while (!stk.isEmpty() && (i == n || histogram[stk.peek()] >= histogram[i])) {
        int height = histogram[stk.pop()];

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

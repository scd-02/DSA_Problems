import java.util.Stack;

public class Stack_MaximumWidthRamp {
  public int maxWidthRamp(int[] nums) {

    Stack<Integer> stk = new Stack<>();

    int ramp = 0;
    for (int i = 0; i < nums.length; i++) {
      if (stk.isEmpty() || nums[i] <= nums[stk.peek()])
        stk.push(i);
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      while (stk.isEmpty() == false && nums[stk.peek()] <= nums[i]) {
        ramp = Math.max(ramp, i - stk.peek());
        stk.pop();
      }
    }

    return ramp;
  }
}

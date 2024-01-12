import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Queue_ReverseFirstKEleOfQueue {
  public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

    Stack<Integer> stk = new Stack<>();

    while (k > 0) {
      int ele = q.poll();
      stk.push(ele);
      k--;
    }

    Queue<Integer> reverse = new LinkedList<>();
    while (!stk.isEmpty()) {
      reverse.add(stk.pop());
    }

    while (!q.isEmpty()) {
      reverse.add(q.poll());
    }

    return reverse;
  }
}

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SW_KSizedSubarrayMaximum {
  public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {

    ArrayList<Integer> ans = new ArrayList<>();

    Deque<Integer> q = new LinkedList<>();

    for (int i = 0; i < arr.length; i++) {

      if (!q.isEmpty() && i - q.peek() >= k) {
        q.removeFirst();
      }

      while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
        q.removeLast();
      }

      q.addLast(i);

      if (i >= k - 1) {
        ans.add(arr[q.peek()]);
      }

      // System.out.println(q);
    }

    return ans;
  }
}

import java.util.ArrayDeque;

public class Queue_MaxValueInSlidingWindow {
  public static void maxValInSlidWind(int a[], int k) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < a.length; i++) {
      if (q.size() > 0 && q.peek() <= i - k)
        q.remove();

      while (q.size() > 0 && a[q.peekLast()] <= a[i])
        q.removeLast();

      q.add(i);
      if (i >= k - 1)
        System.out.print(a[q.peek()] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = { 11, 2, 75, 92, 59, 90, 55 };
    maxValInSlidWind(arr, 3);
  }
}

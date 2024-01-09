import java.util.ArrayDeque;

public class QApp {
  public static void main(String[] args) throws Exception {
    Queue q = new Queue();
    q.insert(12);
    q.insert(20);
    q.insert(30);
    q.insert(40);
    q.display();
    System.out.println();
    System.out.println(josephus(5));
  }

  public static int josephus(int k) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= k; i++) {
      q.add(i);
    }

    while (q.size() != 1) {
      for (int i = 1; i < k; i++) {
        int temp = q.poll();
        q.add(temp);
      }
      q.poll();
    }

    return q.poll();
  }
}

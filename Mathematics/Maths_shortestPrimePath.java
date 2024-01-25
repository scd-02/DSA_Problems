import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maths_shortestPrimePath {
  int solve(int num1, int num2) {

    if (num1 == num2)
      return 0;

    // sieve of erath
    int max_value = 9999;

    int prime[] = new int[10000];
    Arrays.fill(prime, 1);
    prime[1] = 0;
    prime[0] = 0;

    for (int p = 2; p * p <= max_value; p++) {

      if (prime[p] == 1) {

        for (int i = p * p; i <= max_value; i += p) {
          prime[i] = 0;
        }

      }
    }

    // BFS
    int visited[] = new int[10000];
    int steps[] = new int[10000];
    Arrays.fill(steps, -1);
    steps[num1] = 0;

    Queue<Integer> q = new LinkedList<>();
    q.add(num1);

    while (!q.isEmpty()) {

      int u = q.poll();

      if (visited[u] == 1) {
        continue;
      }

      visited[u] = 1;
      String s = Integer.toString(u);

      for (int i = 0; i < 4; i++) {

        for (char ch = '0'; ch <= '9'; ch++) {

          if (ch == s.charAt(i) || (ch == '0' && i == 0))
            continue;

          String next = s.substring(0, i) + ch + s.substring(i + 1);
          int v = Integer.parseInt(next);

          if (prime[v] == 1 && steps[v] == -1) {
            q.add(v);
            steps[v] = 1 + steps[u];
          }

          if (v == num2) {
            return steps[v];
          }
        }

      }
    }

    return steps[num2];
  }
}

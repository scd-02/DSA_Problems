import java.util.ArrayDeque;

public class Array_FirstNegIntInEveryWindowOfSizeK {
  public long[] printFirstNegativeInteger(long a[], int N, int k) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    long[] ans = new long[N - k + 1];
    int j = 0;
    for (int i = 0; i < N; i++) {
      if (q.size() > 0 && q.peek() == i - k) {
        q.remove();
      }

      if (a[i] < 0)
        q.add(i);

      if (i >= k - 1) {
        ans[j++] = q.size() == 0 ? 0 : a[q.peek()];
      }
    }
    return ans;
  }
}

import java.util.ArrayList;
import java.util.List;

public class Array_SumOfQuery2 {
  List<Integer> querySum(int n, int arr[], int q, int queries[]) {
    List<Integer> ans = new ArrayList<>();

    int dp[] = new int[n];
    dp[0] = arr[0];

    for (int i = 1; i < n; i++) {
      dp[i] = dp[i - 1] + arr[i];
    }

    for (int i = 0; i < 2 * q; i = i + 2) {

      int first = queries[i] - 1;
      int last = queries[i + 1] - 1;

      if (first == last) {
        ans.add(arr[first]);
      } else {
        if (first != 0) {
          ans.add(dp[last] - dp[first - 1]);
        } else {
          ans.add(dp[last]);
        }
      }
    }

    return ans;
  }
}

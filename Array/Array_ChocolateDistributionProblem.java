import java.util.ArrayList;
import java.util.Collections;

public class Array_ChocolateDistributionProblem {
  public long findMinDiff(ArrayList<Integer> a, int n, int m) {

    Collections.sort(a);

    long minDiff = Integer.MAX_VALUE;
    for (int i = m - 1; i < n; i++) {

      minDiff = Math.min(minDiff, a.get(i) - a.get(i - m + 1));

    }
    return minDiff;
  }
}

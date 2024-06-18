import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Greedy_MostProfitAssigningWork {
  public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {

    int maxAbility = 0;

    for (int ability : worker) {
      maxAbility = Math.max(ability, maxAbility);
    }

    int[] jobs = new int[maxAbility + 1];

    for (int i = 0; i < difficulty.length; i++) {
      if (difficulty[i] <= maxAbility) {
        jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
      }
    }

    for (int i = 1; i < jobs.length; i++) {
      jobs[i] = Math.max(jobs[i - 1], jobs[i]);
    }

    int netProfit = 0;
    for (int ability : worker) {
      netProfit += jobs[ability];
    }

    return netProfit;
  }

  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

    int n = difficulty.length;
    ArrayList<int[]> jobProfile = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      jobProfile.add(new int[] { difficulty[i], profit[i] });
    }

    Collections.sort(jobProfile, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(worker);

    int i = 0;
    int maxProfit = 0, netProfit = 0;

    for (int j = 0; j < worker.length; j++) {

      while (i < n && jobProfile.get(i)[0] <= worker[j]) {
        maxProfit = Math.max(jobProfile.get(i)[1], maxProfit);
        i++;
      }

      netProfit += maxProfit;
    }

    return netProfit;
  }
}

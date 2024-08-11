import java.util.Arrays;

public class Greedy_JobSequencingProblem {

  class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
    }
  }

  int[] JobScheduling(Job arr[], int n) {

    Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);

    int maxDeadline = Integer.MIN_VALUE;
    for (Job j : arr) {
      maxDeadline = Math.max(maxDeadline, j.deadline);
    }

    boolean slotBooked[] = new boolean[maxDeadline + 1];
    int profit = 0, totalJobs = 0;

    for (Job j : arr) {

      for (int time = j.deadline; time > 0; time--) {
        if (!slotBooked[time]) {
          slotBooked[time] = true;
          profit += j.profit;
          totalJobs++;
          break;
        }
      }
    }

    return new int[] { totalJobs, profit };
  }
}

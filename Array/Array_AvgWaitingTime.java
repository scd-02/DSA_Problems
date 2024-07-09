
public class Array_AvgWaitingTime {

  public double averageWaitingTime(int[][] customers) {

    double waitTime = 0;
    int nextIdleTime = 0;

    for (int i = 0; i < customers.length; i++) {

      nextIdleTime = Math.max(customers[i][0], nextIdleTime) + customers[i][1];
      waitTime += nextIdleTime - customers[i][0];

    }

    return waitTime / customers.length;
  }
}
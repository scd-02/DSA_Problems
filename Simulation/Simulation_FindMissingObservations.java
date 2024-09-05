import java.util.Arrays;

public class Simulation_FindMissingObservations {
  public int[] missingRolls(int[] rolls, int mean, int n) {

    int m = rolls.length;
    int sum_m = 0;
    for (int roll : rolls) {
      sum_m += roll;
    }

    int remainingSum = mean * (n + m) - sum_m;

    if (remainingSum < n || remainingSum > 6 * n) {
      return new int[0];
    }

    int rollCloseToMean = remainingSum / n;
    int mod = remainingSum % n;

    int arr[] = new int[n];
    Arrays.fill(arr, rollCloseToMean);

    for (int i = 0; i < mod; i++) {
      arr[i]++;
    }

    return arr;
  }
}

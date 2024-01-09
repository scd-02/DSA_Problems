public class Array_EquilibriumPoint {
  public static int equilibriumPoint(long arr[], int n) {

    long rightSum = 0;
    long leftSum = 0;

    for (int i = 0; i < n; i++) {
      rightSum += arr[i];
    }

    for (int i = 0; i < n; i++) {

      rightSum = rightSum - arr[i];

      if (rightSum == leftSum) {
        return i + 1;
      }

      leftSum = leftSum + arr[i];

    }

    return -1;
  }
}

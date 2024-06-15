public class Bs_CapacityToShipPackagesWithinDDays {
  public int shipWithinDays(int[] weights, int days) {
    int low = Integer.MIN_VALUE, high = 0;

    for (int wt : weights) {
      high += wt;
      low = Math.max(low, wt);
    }

    while (low <= high) {
      int mid = (low + high) / 2;

      int noOfDays = findDays(weights, mid);
      if (noOfDays <= days) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  int findDays(int[] weights, int mid) {
    int days = 1;
    int load = 0;

    for (int i = 0; i < weights.length; i++) {
      if (load + weights[i] > mid) {
        days++;
        load = weights[i];
      } else {
        load += weights[i];
      }
    }

    return days;
  }
}
